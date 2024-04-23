package cl.psantana.backend_postgresql.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.psantana.backend_postgresql.dto.ChargePointDTO;
import cl.psantana.backend_postgresql.entities.ChargePointEntity;
import cl.psantana.backend_postgresql.repositories.ChargePointRepository;
import cl.psantana.backend_postgresql.services.ChargePointService;
import jakarta.validation.Valid;

@RestController
@Validated
public class ChargePointController {

	@Autowired
	private ChargePointRepository chargePointRepository;
	
	@Autowired
	private ChargePointService chargePointService;
	
	@GetMapping("/chargePoints")
	public ResponseEntity<List<ChargePointEntity>> listChargePoints() {
		List<ChargePointEntity> data = this.chargePointRepository.findAll();
		
		if (data.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	@GetMapping("/chargePoints/{id}")
	public ResponseEntity<ChargePointEntity> listChargePointById(@PathVariable Long id) {
		Optional<ChargePointEntity> data = this.chargePointRepository.findById(id);
		
		if (data.isPresent()) {
			return new ResponseEntity<>(data.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/bestChargingOption")
	public ResponseEntity<Object> bestChargePoints(@RequestParam(name = "latitude", required = false) String lat, @RequestParam(name = "longitude", required = false) String lon) {
		List<String> errores = new ArrayList<String>();
		
		if (lat == null || lat.isBlank()) {
			errores.add("Falta parametro latitude");
		}
		
		if (lon == null || lon.isBlank()) {
			errores.add("Falta parametro longitude");
		}
		
		if (!errores.isEmpty()) {
			Map<String, List<String>> error = new HashMap<>();
			error.put("errores", errores);
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
		
		double latUsu = Double.parseDouble(lat);
		double lonUsu = Double.parseDouble(lon);
		
		System.out.println(this.chargePointService.calcularDistancia(latUsu, lonUsu, Double.parseDouble("38.370344433750745"), Double.parseDouble("-0.4465293635099101")));
		
		Optional<ChargePointEntity> objMasCercano = null;
		double distancia = Double.MAX_VALUE;
		
		for (ChargePointEntity cp: this.chargePointRepository.findAll()) {
			double cpDistancia = this.chargePointService.calcularDistancia(latUsu, lonUsu, Double.parseDouble(cp.getLatitude()), Double.parseDouble(cp.getLongitude()));
			if (cpDistancia < distancia) {
				distancia = cpDistancia;
				objMasCercano = Optional.of(cp);
			}
		}
		
		Optional<ChargePointEntity> objMayorPower = this.chargePointRepository.findAll()
				.stream()
				.max((obj1, obj2) -> Integer.compare(obj1.getPower(), obj2.getPower()));
		
		if (objMasCercano.isPresent() && objMayorPower.isPresent()) {
			Map<String, ChargePointEntity> respuesta = new HashMap<>();
			respuesta.put("chargePointBestDistance", objMasCercano.get());
			respuesta.put("chargePointBestPower", objMayorPower.get());
			
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/chargePoints")
	public ResponseEntity<Object> createChargePoints(@Valid @RequestBody(required = false) ChargePointDTO chargePointDTO) {
		System.out.println(chargePointDTO);
		if (chargePointDTO == null) {
			Map<String, String> error = new HashMap<>();
			error.put("error", "El cuerpo de la solicitud no puede estar vacio");
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
		ChargePointEntity chargePointEntity = new ChargePointEntity(chargePointDTO.getStatus(), chargePointDTO.getOperator(), chargePointDTO.getConnections(), chargePointDTO.getLatitude(), chargePointDTO.getLongitude(), chargePointDTO.getCountry(), chargePointDTO.getPower());
		this.chargePointRepository.save(chargePointEntity);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
