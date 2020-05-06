package com.convertcurrency.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.convertcurrency.proxy.ICurrencyConversionFactorProxy;


@Service
public class ConvertCurrencyService {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ICurrencyConversionFactorProxy proxy;
	

	 public double getConversionFactor(String fromCurrency, String toCurrency)
	 {
		 double conversionFactor = proxy.getConversionFactor(fromCurrency, toCurrency);
			log.info("factor" +conversionFactor);
			return conversionFactor;
	 }
	 
	 
	public String convertCurrency(String fromCurrency, String toCurrency, double amount) {
		double conversionFactor = getConversionFactor(fromCurrency,toCurrency);
		return "Converted amount is " + amount * conversionFactor;
	
	}
	 
	 
	 

}
