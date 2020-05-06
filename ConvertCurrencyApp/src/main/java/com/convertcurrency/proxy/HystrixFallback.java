package com.convertcurrency.proxy;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class HystrixFallback implements ICurrencyConversionFactorProxy {

	Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public double getConversionFactor(String sourceCountry, String destCountry) {
		log.info("executing fallback method and returning conversion factor 0.0");
		return 0.0;
	}
}
