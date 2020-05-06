package com.currencyconversion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.currencyconversion.ExceptionHandler.NODataFoundException;
import com.currencyconversion.Repository.ConversionFactorRepo;
import com.currencyconversion.entity.CurrencyConversion;
import com.currencyconversion.entity.ErrorResponse;

@Service
public class CurrencyConversionService {

	@Autowired
	ConversionFactorRepo factorRepo;
	
	Logger LOG = LoggerFactory.getLogger(CurrencyConversionService.class);
	
	public CurrencyConversion createconversionFactor(CurrencyConversion currencyConversion) throws PersistenceException
	{
		try {
			factorRepo.save(currencyConversion);
			return currencyConversion;
		}
		catch(PersistenceException e) {
			LOG.error("Error occured while saving to the database: ", e);
			throw e;
		}
		
	}

	public List<CurrencyConversion> getAllConversionfactor() 
	{
		return factorRepo.findAll();
	}


	public List<CurrencyConversion> getConversionfactorbyCurrency(String currency)  throws NODataFoundException
	{
		List<String> currencyList= new ArrayList<String>();
		currencyList.add(currency);
		
		List<CurrencyConversion> currencyConversionList= factorRepo.findByCurrencyIn(currencyList);
		
		if(currencyConversionList.size()==0)
			throw new NODataFoundException("400", "Given Currency" +currency +" details are not found. Please try again !!") ;
		return currencyConversionList;
		
	}

	public double getConversionFactor(String fromcurrencycode, String tocurrencycode) throws NODataFoundException
	{
		double conversionFactor=0;
		List<String> currencyList= new ArrayList<String>();
		currencyList.add(fromcurrencycode);
		currencyList.add(tocurrencycode);
		
		List<CurrencyConversion> currencyConversionList= factorRepo.findByCurrencyIn(currencyList);
		if(currencyConversionList.size()==0)
		{
			throw new NODataFoundException("400", "Given Currency" +fromcurrencycode + " " + tocurrencycode +" details are not found. Please try again !!") ;
		}
		else if(currencyConversionList.size()>0)
		{
			double fromcurrency_conversionFactor=0,tocurrency_conversionFactor=0;
			//traverse List and check 
			for(CurrencyConversion currencyConversion:currencyConversionList)
			{
				if(currencyConversion.getCurrency().equalsIgnoreCase(tocurrencycode))
				{
					tocurrency_conversionFactor=currencyConversion.getConversion_factor();
				}
				else if(currencyConversion.getCurrency().equalsIgnoreCase(fromcurrencycode))
				{
					fromcurrency_conversionFactor=currencyConversion.getConversion_factor();
				}
			}
			
			if(tocurrency_conversionFactor==0)
			{
				throw new NODataFoundException("400", "Given Currency" + tocurrencycode +" details are not found. Please try again !!") ;
			}
			else if(fromcurrency_conversionFactor==0)
			{
				throw new NODataFoundException("400", "Given Currency" + fromcurrencycode +" details are not found. Please try again !!") ;
			}
			
			
			conversionFactor = fromcurrency_conversionFactor/tocurrency_conversionFactor;
			
		}
		return conversionFactor;

		
	}
	
	  public CurrencyConversion updateConversionFactor(CurrencyConversion currencyConversion) throws PersistenceException, NODataFoundException
	  { 
		  List<String> currList = new ArrayList<>();
		  currList.add(currencyConversion.getCurrency());
	   List<CurrencyConversion> conversionFactorList= factorRepo.findByCurrencyIn(currList);
	  
	  if(conversionFactorList.size()==0)
		  throw new NODataFoundException("400", "Given countries combination does not exists, so No data found in DB. Data can not be updated");
	  
	  conversionFactorList.get(0).setConversion_factor(currencyConversion.getConversion_factor ()); 
	  return factorRepo.save(conversionFactorList.get(0));
	  }

	
	 

}
