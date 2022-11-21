package org.generation.italy;

import java.math.BigDecimal;

public class Biglietto {
	
	
	//costanti
	static final BigDecimal COSTO_KM = new BigDecimal("0.21");
	static final BigDecimal SCONTO_OVER = new BigDecimal("0.6");
	static final BigDecimal SCONTO_UNDER = new BigDecimal("0.8");
	
	
	
	//attributi
	private int km;
	private int age;
	
	//costruttore
	public Biglietto(int km,int age) throws Exception{
		this.km = km;
		this.age = age;
		
		
		if (!isValidkm() || !isValidAge()) {	
			throw new Exception("Inserisci un valore valido");
		}
	}
	
	private boolean isValidkm() {
		if(km <= 0 || km > 10000) {
			return false;
		} else {
			return true;
		}
	}
	
	private boolean isValidAge() {
		if(age <= 0 || age > 120) {
			return false;
		} else {
			return true;
		}
				
	}
	
	private BigDecimal calcolaSconto() {
		if(age < 18) {
			return SCONTO_UNDER.multiply(COSTO_KM);
		}else if( age > 65) {
			return SCONTO_OVER.multiply(COSTO_KM);
		}else {
			return COSTO_KM;
		}
		
	}
	
	public BigDecimal calcolaPrezzo() {
		return calcolaSconto().multiply(BigDecimal.valueOf(km).multiply(BigDecimal.valueOf(1.10)));
		
	}
	
	@Override
	public String toString() {	
		return "Il numero di km che vuoi percorrere: " + km + "\nLa tua età: " + age + "\nIl prezzo del tuo biglietto: " 
	+ calcolaPrezzo() + "euro";
	}
	
	

	
	
	
	
	

}
