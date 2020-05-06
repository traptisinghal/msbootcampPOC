
  package com.currencyconversion.Repository;
  
  import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.currencyconversion.entity.CurrencyConversion;
  
@Repository
  public interface ConversionFactorRepo extends JpaRepository<CurrencyConversion, Integer> {

	
	public List<CurrencyConversion> findByCurrencyIn(List<String> currency);
  }

 