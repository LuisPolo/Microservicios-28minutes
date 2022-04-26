package pe.com.techniser.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment enviroment;

	@Autowired
	private CurrencyExchangeRepository repository;

	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

	@GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		logger.info("Se devuelve el valor de cambio de {} {}", from, to);

		// CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to,
		// BigDecimal.valueOf(50));
		CurrencyExchange currencyExchange = repository.findByCurrencyfromAndCurrencyto(from, to);

		if (currencyExchange == null) {

			throw new RuntimeException("No se encontro el caso de " + from + "to " + to);
		}

		String port = enviroment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);

		return currencyExchange;
	}

}
