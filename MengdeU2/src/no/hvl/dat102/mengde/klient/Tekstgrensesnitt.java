package no.hvl.dat102.mengde.klient;

import java.util.Scanner;
import no.hvl.dat102.mengde.klient.Medlem;
import no.hvl.dat102.mengde.klient.*;
import no.hvl.dat102.mengde.tabell.*;

public class Tekstgrensesnitt {
	private static Datakontakt data;
	
		public Tekstgrensesnitt(Datakontakt data) {
			Tekstgrensesnitt.data = data;
		
		}
		public static Medlem lesMedlem(){
			
			Scanner read = new Scanner(System.in);  // lager scanner
			String navn;
			String f�dsels�r; 
			String status; 
			String innskrevetStatus = "";
			
			System.out.println("Velkommen som nytt medlem, venligst svar �rlig p� f�lgende sp�rmsm�l.\n"); // println går på ny linje når den er ferdig
			System.out.print("Navn: "); // bruker vanlig print siden jeg ønsker at når personen skriver i teminalen så står det vedsiden av Navn: 
		    navn = read.nextLine(); // legger til verdien du skriver inn på variabelen navn
		    System.out.print("Oppgi f�dsels�r p� formen DD/MM/YYYY: ");
		    f�dsels�r = read.nextLine();
		    System.out.println("Velg en av f�lgende statuser 1: Singel, 2: Gift eller 3: I forhold");
		    System.out.print("Status: ");
		    status = read.nextLine();
		    if (status.equals("1")) {
		    	innskrevetStatus = "singel";
		    } else if (status.equals("2")) {
		    	innskrevetStatus = "Gift";
		    	} else if (status.equals("3"))  {
		    		innskrevetStatus = "i forhold";
		    	} else {
		    		innskrevetStatus ="Ugyldig svar alternativ";
		    	}
		   System.out.println(innskrevetStatus);
		    read.close();
		    Medlem nyMedlem = new Medlem(navn);
		    return nyMedlem;
		}  
		 
		// Skriver ut hobbylisten for et medlem 
		public static void skrivHobbyListe(Medlem medlem) {  
		    System.out.println("Alle hobbyene "); 
		    System.out.println(medlem.getHobbyer().toString()); 
		} 
		public static void skrivParListe (Datakontakt arkiv){ 
			Datakontakt kopi = arkiv;
			String liste = "";
			String partnerNavn = "";
			Medlem m1;
			Medlem m2;
			Medlem[] m = kopi.getMedlemTab(); // navn på tabellen vår!!!
			int st�rrelse = kopi.getAntallMedlemmer();
			
			for(int i = 0; i < st�rrelse; i++) {
				
				m1 = m[i];
				
				if(m1.getStatusIndeks() > i || m1.getStatusIndeks() == -1) {
					liste += m1.getNavn() + " og ";
					kopi.finnPartnerFor(m1.getNavn());
					if(m1.getStatusIndeks() != -1) {
						m2 = m[m1.getStatusIndeks()];
						partnerNavn = m2.getNavn();
			
					}else
						partnerNavn = "(ingen partner)";
					liste += partnerNavn + " ";
					liste += m1.getHobbyer();
					liste += "\n";
				}
			}
			System.out.println(liste);

}
	}

