package com.convertcurrency.entity;

public class CurrencyConvertDetail {

	String source_country;
	String dest_country;
	double converted_amount;
	double conversion_factor;
	
	public CurrencyConvertDetail()
	{
		
	}
	
	
	public CurrencyConvertDetail(String source_country, String dest_country, double converted_amount,double conversion_factor) {
		super();
		this.source_country = source_country;
		this.dest_country = dest_country;
		this.converted_amount = converted_amount;
		this.conversion_factor = conversion_factor;
	}
	
	public CurrencyConvertDetail(String source_country, String dest_country, double conversion_factor) {
		super();
		this.source_country = source_country;
		this.dest_country = dest_country;
		this.conversion_factor = conversion_factor;
	}
	
	public String getSource_country() {
		return source_country;
	}
	public void setSource_country(String source_country) {
		this.source_country = source_country;
	}
	public String getDest_country() {
		return dest_country;
	}
	public void setDest_country(String dest_country) {
		this.dest_country = dest_country;
	}
	public double getConverted_amount() {
		return converted_amount;
	}
	public void setConverted_amount(double converted_amount) {
		this.converted_amount = converted_amount;
	}
	
	public double getConversion_factor() {
		return conversion_factor;
	}
	public void setConversion_factor(double conversion_factor) {
		this.conversion_factor = conversion_factor;
	}
	@Override
	public String toString() {
		return "CurrencyConvertDetail [source_country=" + source_country + ", dest_country=" + dest_country
				+ ", converted_amount=" + converted_amount + ", conversion_factor=" + conversion_factor + "]";
	}


	
	
	
}
