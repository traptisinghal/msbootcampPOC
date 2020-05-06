package com.currencyconversion.restcontroller;

import java.util.List;

import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.currencyconversion.ExceptionHandler.NODataFoundException;
import com.currencyconversion.entity.BuildResponseUtil;
import com.currencyconversion.entity.CurrencyConversion;
import com.currencyconversion.service.CurrencyConversionService;

@RestController
public class CurrencyConversionController {

	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	CurrencyConversionService currencyService;

	private static final String SUCCESS_RESOURCECREATED_MESSAGE = "successfully added";
	private static final String SUCCESS_RESOURCEUPDATED_MESSAGE = "successfully updated";

	@PostMapping("/conversionfactor")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	public BuildResponseUtil createConversionFactor(@RequestBody CurrencyConversion currencyConversion)
			throws PersistenceException {
		log.info("Adding new conversion factor of countries");
		currencyService.createconversionFactor(currencyConversion);
		return new BuildResponseUtil(HttpStatus.CREATED.toString(), SUCCESS_RESOURCECREATED_MESSAGE,
				currencyConversion);
	}

	@GetMapping("/conversionfactor")
	public List<CurrencyConversion> getAllConversionfactor() {
		log.info("Get all conversion factor details from database");
		return currencyService.getAllConversionfactor();
	}
	
	
	@GetMapping("/conversionfactor/{currency}")
	public List<CurrencyConversion> getConversionfactorbyCurrency(@PathVariable String currency) throws NODataFoundException {
		log.info("Get conversion factor based on given currency");
		return currencyService.getConversionfactorbyCurrency(currency);
	}
	

	@GetMapping("/conversionfactor/{fromcurrency}/{tocurrency}")
	public double getConversionFactor(@PathVariable String fromcurrency, @PathVariable String tocurrency) throws NODataFoundException 
	{
		log.info("Get conversion factor between two currencies");
		return currencyService.getConversionFactor(fromcurrency, tocurrency);
	}

	 @PutMapping("/conversionfactor")
	 @ResponseBody
	 @ResponseStatus(value= HttpStatus.OK) 
	 public BuildResponseUtil updateConversionFactor(@RequestBody CurrencyConversion currencyConversion)  throws PersistenceException, NODataFoundException 
	 { 
		 log.info("update conversion factor for specified source destination countries");
	  currencyConversion = currencyService.updateConversionFactor(currencyConversion); 
	  return new BuildResponseUtil(HttpStatus.OK.toString(),SUCCESS_RESOURCEUPDATED_MESSAGE, currencyConversion); 
	 }

}
