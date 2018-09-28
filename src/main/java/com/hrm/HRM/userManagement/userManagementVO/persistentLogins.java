package com.hrm.HRM.userManagement.userManagementVO;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class persistentLogins {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="series")
	private long series;
	
	@Column(name = "username")
    private String username;
	
	@Column(name = "token")
    private String token;
	
	@Column(name = "lastUsed")
    private Timestamp lastUsed;

	public long getSeries() {
		return series;
	}

	public void setSeries(long series) {
		this.series = series;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Timestamp getLastUsed() {
		return lastUsed;
	}

	public void setLastUsed(Timestamp lastUsed) {
		this.lastUsed = lastUsed;
	}

	public persistentLogins(long series, String username, String token, Timestamp lastUsed) {
		super();
		this.series = series;
		this.username = username;
		this.token = token;
		this.lastUsed = lastUsed;
	}

	public persistentLogins() {
		super();
	}
	
	

}
