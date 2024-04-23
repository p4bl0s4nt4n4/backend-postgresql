package cl.psantana.backend_postgresql.dto;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotBlank;

public class ChargePointDTO {
	@NotBlank(message = "Falta ingresar parametro status")
	private String status;
	
	@NotBlank(message = "Falta ingresar parametro operator")
	private String operator;
	
	@Range(min = 1, message = "Falta ingresar parametro connections")
	private int connections;
	
	@NotBlank(message = "Falta ingresar parametro latitude")
	private String latitude;
	
	@NotBlank(message = "Falta ingresar parametro longitude")
	private String longitude;
	
	@NotBlank(message = "Falta ingresar parametro country")
	private String country;
	
	@Range(min = 1, message = "Falta ingresar parametro power")
	private int power;

	public ChargePointDTO() {
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public int getConnections() {
		return connections;
	}

	public void setConnections(int connections) {
		this.connections = connections;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
}
