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
		
		tab.leggTilMedlem(new Medlem("Nils", hobbier1));
		tab.leggTilMedlem(new Medlem("Hanne", hobbier2));
		tab.leggTilMedlem(new Medlem("Mons", hobbier1));
		tab.leggTilMedlem(new Medlem("Live", hobbier2));
		System.out.println(tab.toString());
	
	}
}
		
