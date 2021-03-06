package pe.com.techniser.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
 
	
	@GetMapping(path="/sample-api")
	//@Retry(name="ejemplo-api", fallbackMethod = "hardcodedResponse")
	@CircuitBreaker(name="default", fallbackMethod = "hardcodedResponse")
	@RateLimiter(name="default")
	@Bulkhead(name="default")
	public String sampleApi() {
		logger.info("Ejemplo lanzamiento de api");
		new RestTemplate().getForEntity("http://localhost:8080/some-dummy", String.class);
		
		return "Sample API";
		
	}
	
	public String hardcodedResponse(Exception ex) {
		logger.info("Fallback response");
			
		return "Fallback response";
		
	}

}
