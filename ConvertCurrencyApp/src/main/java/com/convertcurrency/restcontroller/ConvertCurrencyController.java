package com.convertcurrency.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.convertcurrency.entity.CurrencyConvertDetail;
import com.convertcurrency.proxy.ICurrencyConversionFactorProxy;
import com.convertcurrency.service.ConvertCurrencyService;
@RestController
public class ConvertCurrencyController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ConvertCurrencyService curService;
	
	@GetMapping("currency/conversionfactor/{amount}/{fromCurrency}/{toCurrency}")
	public String convertCurrency(@PathVariable String fromCurrency, @PathVariable String toCurrency, @PathVariable double amount)
	{
		log.info("in ConvertCurrencyController");
		return curService.convertCurrency(fromCurrency, toCurrency, amount);
		
			
	}
}
