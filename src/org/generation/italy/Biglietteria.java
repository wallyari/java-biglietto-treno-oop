package org.generation.italy;

import java.util.Scanner;

public class Biglietteria {
    public static void main(String[] args) {
        
    	Scanner scanner = new Scanner(System.in);
        int age; int km;
        
        System.out.println("Inserire il numero di km da percorrere:");
        km = scanner .nextInt();
        
        System.out.println("Inserisci la tua età:");
        age = scanner .nextInt();
        
        try {
            Biglietto ticket = new Biglietto(km, age);
            System.out.println(ticket);
            //System.out.println("Il prezzo del tuo biglietto è: "+ ticket.calcolaPrezzo());
        
            
        } catch (Exception e) {
        	System.out.println("Inserisci età valida / Inserisci km validi");
        }
    }

}
