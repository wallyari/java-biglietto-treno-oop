package org.generation.italy;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Biglietto {
	
	
	//costanti
	static final BigDecimal COSTO_KM = new BigDecimal(".21");
	static final BigDecimal SCONTO_OVER = new BigDecimal("0.4");
	static final BigDecimal SCONTO_UNDER = new BigDecimal("0.2");
	static final int NORMAL = 30;
	static final int FLESSIBILE = 90;
	
	
	
	//attributi
	private int km;
	private int age;
	private LocalDate date;
	private boolean flessibile;
	
	
	//costruttore
	public Biglietto(int km,int age, boolean flessibile) throws Exception{
		this.km = km;
		this.age = age;
		this.date = LocalDate.now();
		this.flessibile = flessibile;
		
			
		
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
		if (flessibile) {
		return calcolaSconto().multiply(BigDecimal.valueOf(km).multiply(BigDecimal.valueOf(1.10)));
		}
		return calcolaSconto().multiply(BigDecimal.valueOf(km));
	}
	
	
	public LocalDate calcolaDataScadenza() {
		if (flessibile) {
			return date.plusDays(FLESSIBILE);
			
		}else {
			return date.plusDays(NORMAL);
		}
	}
	
	@Override
	public String toString() {	
		return "Il numero di km che vuoi percorrere: " + km + "\nLa tua età: " + age + "\nIl prezzo del tuo biglietto: " 
	+ calcolaPrezzo() + " euro" + "\nData di scadenza del biglietto: " + calcolaDataScadenza();
	}
	
	

	
	
	
	
	

}
