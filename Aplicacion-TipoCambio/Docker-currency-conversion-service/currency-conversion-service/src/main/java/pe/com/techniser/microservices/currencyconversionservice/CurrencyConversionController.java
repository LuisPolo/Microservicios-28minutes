package pe.com.techniser.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy proxy;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(
			@PathVariable("from") String from,
			@PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity
			) {
		
		HashMap<String, String> urivariable = new HashMap<String, String>();
		urivariable.put("from", from);
		urivariable.put("to", to);
		
		ResponseEntity<CurrencyConversion> responseEntity =  
				new RestTemplate().getForEntity(/*"http://localhost:8000/currency-exchange/from/{from}/to/{to}"*/
						"http://currency-exchange-service:8000/currency-exchange/from/{from}/to/{to}",
				CurrencyConversion.class, urivariable);
		
		CurrencyConversion currencyConversion = responseEntity.getBody();
		
		//return new CurrencyConversion(1000L, from, to, 10, quantity, new BigDecimal(5.5), "");
		
		return new CurrencyConversion (
				currencyConversion.getId(), 
				from, 
				to, 
				quantity, 
				currencyConversion.getconversionMultiple(), 
				quantity.multiply(currencyConversion.getconversionMultiple()),
				currencyConversion.getEnvironment());
		
		
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionFeign(
			@PathVariable("from") String from,
			@PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity
			) {
		
	
		
		CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);
		
		//return new CurrencyConversion(1000L, from, to, 10, quantity, new BigDecimal(5.5), "");
		
		return new CurrencyConversion (
				currencyConversion.getId(), 
				from, 
				to, 
				quantity, 
				currencyConversion.getconversionMultiple(), 
				quantity.multiply(currencyConversion.getconversionMultiple()),
				currencyConversion.getEnvironment() + "-feign");
		
		
	}
	
}
