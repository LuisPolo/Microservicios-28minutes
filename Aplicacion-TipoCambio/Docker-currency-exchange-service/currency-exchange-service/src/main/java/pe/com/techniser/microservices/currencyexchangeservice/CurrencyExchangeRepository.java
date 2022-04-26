package pe.com.techniser.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
	
	
	CurrencyExchange findByCurrencyfromAndCurrencyto(String from, String to);
	
	

}
