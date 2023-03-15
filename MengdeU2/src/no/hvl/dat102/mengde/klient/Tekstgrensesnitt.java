package no.hvl.dat102.mengde.klient;

import java.util.Scanner;

public class Tekstgrensesnitt {
	private static Datakontakt data;
	
		public Tekstgrensesnitt(Datakontakt data) {
			Tekstgrensesnitt.data = data;
		
		}
		public static Medlem lesMedlem(){
			
			Scanner read = new Scanner(System.in);  // lager scanner
			//thing jeg Ã¸nsker dere skal legge til.
			String navn;
			String fødselsår; // i format DD/MM/YYYY  eksempel 17/5/1994  Bruker mÃ¥ kunne fÃ¥ lov til Ã¥ skrive det i det formate
			String status = ""; // tenk facebook. [singel, gift, i forhold] ect (her skal det barevÃ¦re lov Ã¥ skrive inn de 3 tingene. fÃ¥reslÃ¥r Ã¥ skrive ut alle 3 ogsÃ¥ ha brukeren bare trykke 1,2 eller 3 for hvilke som gjelder de.
			
			//forslag til hvordan dere kan gjÃ¸re det.
			System.out.println(" Velkommen som nytt medlem,\n venligst svar ærligt på følgende spørmsmål.\n"); // println gÃ¥r pÃ¥ ny linje nÃ¥r den er ferdig
			System.out.print("Navn: "); // bruker vanlig print siden jeg Ã¸nsker at nÃ¥r personen skriver i teminalen sÃ¥ stÃ¥r det vedsiden av Navn: 
		    navn = read.nextLine(); // legger til verdien du skriver inn pÃ¥ variabelen navn
		    System.out.print("Oppgi fødselsår på formen DD/MM/YYYY: ");
		    fødselsår = read.nextLine();
		    System.out.println("Velg en av følgende statuser 1: Singel, 2: Gift eller 3: I forhold");
		    System.out.print("Status: ");
		    if (status == "1") {
		    	status = "Singel";
		    } else if (status == "2") {
		    		status = "Gift";
		    	} else if (status == "3") {
		    		status = "i forhold";
		    	} else {
		    		status = "Ugyldig svar alternativ/ Ønsker ikke oppgi";
		    	}
		    status = read.nextLine();
		    return medlem;
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
			Medlem[] m = kopi.getMedlemsTabell(); // navn pÃ¥ tabellen vÃ¥r!!!
			int størrelse = kopi.getAntall();
			
			for(int i = 0; i < størrelse; i++) {
				
				m1 = m[i];
				
				if(m1.getStatusIndeks() > i || m1.getStatusIndex() == -1) {
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

