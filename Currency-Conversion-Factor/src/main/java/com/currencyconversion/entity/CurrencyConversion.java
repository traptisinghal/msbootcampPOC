package com.currencyconversion.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class CurrencyConversion {

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	int id;
	
	String country;
	
	String currency;
	
	double conversion_factor;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getConversion_factor() {
		return conversion_factor;
	}

	public void setConversion_factor(double conversion_factor) {
		this.conversion_factor = conversion_factor;
	}
	
}
