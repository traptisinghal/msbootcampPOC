package com.convertcurrency.proxy;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.convertcurrency.entity.CurrencyConvertDetail;

@Component
//@FeignClient(name="Currency-Conversion-Factor", url="localhost:8081") //hard coded URL
//if multiple instances of "Currency-Conversion-Factor" are running, better to use discovery service Eureka
@FeignClient(name="CurrencyConversionFactor", fallback = HystrixFallback.class) //Used hystrix circuit breaker if in case "Currency-Conversion-Factor" does not respond 

public interface ICurrencyConversionFactorProxy {

	@GetMapping("/conversionfactor/{fromcurrency}/{tocurrency}")
	@Cacheable("conversionFactor")
	public double getConversionFactor(@PathVariable("fromcurrency") String fromCurrency, @PathVariable("tocurrency") String toCurrency);
	 
}
