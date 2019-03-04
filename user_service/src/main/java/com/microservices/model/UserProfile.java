package com.microservices.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserDetails")
public class UserProfile {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String vorname;
	@Column(name="Brith")
	private Date dateOfBirth;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	public UserProfile(String name, String vorname, Date dateOfBirth) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.dateOfBirth = dateOfBirth;
	}
	
	public UserProfile() {
		super();
	}
}
