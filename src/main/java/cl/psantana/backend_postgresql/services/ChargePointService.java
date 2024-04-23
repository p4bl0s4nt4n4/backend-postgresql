package cl.psantana.backend_postgresql.services;

import org.springframework.stereotype.Service;

@Service
public class ChargePointService {
	
	public double calcularDistancia(double latUsu, double lonUsu, double lat, double lon) {
		// Radio de la tierra en kilometros
		final double radioTierra = 6371.0;
		
		// Pasar a radianes
		double latUsuRad = Math.toRadians(latUsu);
		double lonUsuRad = Math.toRadians(lonUsu);
		double latRad = Math.toRadians(lat);
		double lonRad = Math.toRadians(lon);
		
		// Diferencias
		double dLat = latRad - latUsuRad;
		double dLon = lonRad - lonUsuRad;
		
		// Fórmula de Haversine
		
		double a = Math.pow(Math.sin(dLat / 2), 2) + 
					Math.cos(latUsuRad) * Math.cos(latRad) *
					Math.pow(Math.sin(dLon / 2), 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		
		double distancia = radioTierra * c;
		return distancia;
	}
}
