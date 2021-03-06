package pe.com.techniser.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.techniser.microservices.limitsservice.bean.Limits;
import pe.com.techniser.microservices.limitsservice.configuration.Configuration;


@RestController
public class LimitsController {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping(path = "/limits")
	public Limits retrieveLimits() {
		
		return new Limits(configuration.getMinimum(), configuration.getMaximum());
		
	}

}
