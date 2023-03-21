package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.mengde.tabell.TabellMengde;

public class KlientMedlem {

	public static void main(String[] args) { 
		Datakontakt tab = new Datakontakt();
		
		String[] hobbier = {
				"Male",
				"Tegne",
				"Klatre", 
				"Programmere", 
				"Fotball"
		};
		TabellMengde<Hobby> hobbier1 = new TabellMengde<>();
		TabellMengde<Hobby> hobbier2 = new TabellMengde<>();
		
		hobbier1.leggTil(new Hobby("fotball"));
		hobbier1.leggTil(new Hobby("tennis"));
		
		hobbier2.leggTil(new Hobby("basket"));
		hobbier2.leggTil(new Hobby("lasertag"));
		
		
		tab.leggTilMedlem(new Medlem("Nils", hobbier1));
		tab.leggTilMedlem(new Medlem("Hanne", hobbier2));
		tab.leggTilMedlem(new Medlem("Mons", hobbier1));
		tab.leggTilMedlem(new Medlem("Live", hobbier2));

		System.out.println("Antall medlemmer: " + tab.getAntallMedlemmer());
		System.out.println(tab.finnMedlem(0).getHobbyer());
		System.out.println(tab.finnMedlem(2).getHobbyer());

		for(int i = 0; i < tab.getAntallMedlemmer(); i++) {
			System.out.printf("en god partner for %s er: %s \n",tab.finnMedlem(i).getNavn(), tab.finnPartnerFor(tab.finnMedlem(i).getNavn()));

		}
	
	}
}
		
