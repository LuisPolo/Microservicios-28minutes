package pe.com.techniser.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CurrencyExchange {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String currencyfrom;
	private String currencyto;
	private BigDecimal conversionMultiple;
	private String environment;
	
	public CurrencyExchange() {
		// TODO Auto-generated constructor stub
	}

	public CurrencyExchange(Long id, String currencyfrom, String currencyto, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.currencyfrom = currencyfrom;
		this.currencyto = currencyto;
		this.conversionMultiple = conversionMultiple;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getCurrencyfrom() {
		return currencyfrom;
	}

	public void setCurrencyfrom(String currencyfrom) {
		this.currencyfrom = currencyfrom;
	}

	public String getCurrencyto() {
		return currencyto;
	}

	public void setCurrencyto(String currencyto) {
		this.currencyto = currencyto;
	}

	public BigDecimal getConversion() {
		return conversionMultiple;
	}

	public void setConversion(BigDecimal conversion) {
		this.conversionMultiple = conversion;
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}



}
