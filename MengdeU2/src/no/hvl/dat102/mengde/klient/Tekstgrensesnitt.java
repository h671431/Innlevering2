package no.hvl.dat102.mengde.klient;

import java.util.Scanner;

public class Tekstgrensesnitt {
	private static Datakontakt data;
	
		public Tekstgrensesnitt(Datakontakt data) {
			Tekstgrensesnitt.data = data;
		
		}
		public static Medlem lesMedlem(){
			
			Scanner read = new Scanner(System.in);  // lager scanner
			//thing jeg ønsker dere skal legge til.
			String navn;
			String f�dsels�r; // i format DD/MM/YYYY  eksempel 17/5/1994  Bruker må kunne få lov til å skrive det i det formate
			String status = ""; // tenk facebook. [singel, gift, i forhold] ect (her skal det barevære lov å skrive inn de 3 tingene. fåreslår å skrive ut alle 3 også ha brukeren bare trykke 1,2 eller 3 for hvilke som gjelder de.
			
			//forslag til hvordan dere kan gjøre det.
			System.out.println(" Velkommen som nytt medlem,\n venligst svar �rligt p� f�lgende sp�rmsm�l.\n"); // println går på ny linje når den er ferdig
			System.out.print("Navn: "); // bruker vanlig print siden jeg ønsker at når personen skriver i teminalen så står det vedsiden av Navn: 
		    navn = read.nextLine(); // legger til verdien du skriver inn på variabelen navn
		    System.out.print("Oppgi f�dsels�r p� formen DD/MM/YYYY: ");
		    f�dsels�r = read.nextLine();
		    System.out.println("Velg en av f�lgende statuser 1: Singel, 2: Gift eller 3: I forhold");
		    System.out.print("Status: ");
		    if (status == "1") {
		    	status = "Singel";
		    } else if (status == "2") {
		    		status = "Gift";
		    	} else if (status == "3") {
		    		status = "i forhold";
		    	} else {
		    		status = "Ugyldig svar alternativ/ �nsker ikke oppgi";
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
			Medlem[] m = kopi.getMedlemsTabell(); // navn på tabellen vår!!!
			int st�rrelse = kopi.getAntall();
			
			for(int i = 0; i < st�rrelse; i++) {
				
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

