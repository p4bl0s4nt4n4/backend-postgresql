package cl.psantana.backend_postgresql.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "charge_points")
public class ChargePointEntity {
	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "status")
	private String status;

	@Column(name = "operator")
	private String operator;

	@Column(name = "connections")
	private int connections;

	@Column(name = "latitude")
	private String latitude;

	@Column(name = "longitude")
	private String longitude;

	@Column(name = "country")
	private String country;

	@Column(name = "power")
	private int power;
	
	public ChargePointEntity() {}

	public ChargePointEntity(String status, String operator, int connections, String latitude, String longitude,
			String country, int power) {
		this.status = status;
		this.operator = operator;
		this.connections = connections;
		this.latitude = latitude;
		this.longitude = longitude;
		this.country = country;
		this.power = power;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
