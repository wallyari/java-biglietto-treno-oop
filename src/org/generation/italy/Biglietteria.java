package org.generation.italy;

import java.util.Scanner;

public class Biglietteria {
    public static void main(String[] args) {
        
    	Scanner scanner = new Scanner(System.in);
        boolean flessibile;
        String sceltaFlex = "";
            
        
        try {
        	 
        	 
             System.out.println("Inserire il numero di km da percorrere:");
             int km = scanner .nextInt();
             
             System.out.println("Inserisci la tua età:");
             int age = scanner .nextInt();
             scanner.nextLine();
             
             System.out.println("Vuoi usufruire del metodo flessibile?: (si/no)");
             sceltaFlex = scanner.nextLine();
             
             if(sceltaFlex.equalsIgnoreCase("si")) {
             	flessibile = true;
             } else {
             	flessibile = false;
             }
             
             Biglietto ticket = new Biglietto(km, age, flessibile);
             System.out.println(ticket);
             //System.out.println("Il prezzo del tuo biglietto è: "+ ticket.calcolaPrezzo());
           
        
            
        } catch (Exception e) {
        	System.out.println("Inserisci età valida / Inserisci km validi");
        }
        scanner.close();
    }

}
