package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.mengde.klient.Datakontakt;
import no.hvl.dat102.mengde.klient.Hobby;
import no.hvl.dat102.mengde.klient.Medlem;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;


public class KlientDatakontakt {

	public static void main(String[] args) {
		
		Datakontakt dk = new Datakontakt();
		Medlem nyMedlem = Tekstgrensesnitt.lesMedlem();
		dk.leggTilMedlem(nyMedlem);
		KjedetMengde<Hobby> h1 = new KjedetMengde<>();
		
		h1.leggTil(new Hobby("Sjakk"));
		h1.leggTil(new Hobby("Volleyball"));
		
		Medlem m1 = new Medlem("Anders", h1);
		Medlem m2 = new Medlem("Per", h1);
		Medlem m3 = new Medlem("Line", h1);
		
		dk.leggTilMedlem(m1);
		dk.leggTilMedlem(m2);
		dk.leggTilMedlem(m3);
	
//		System.out.println("Alle parene:");
//		Tekstgrensesnitt.skrivParListe(dk);

	}

}
