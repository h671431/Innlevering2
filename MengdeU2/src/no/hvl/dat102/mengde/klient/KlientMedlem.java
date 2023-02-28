package no.hvl.dat102.mengde.klient;

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
		
		System.out.println(tab.toString());
		//utskrift();
		//toString
	}
		
		//public void utskrift() {
		//System.out.println("Medlemsnavn: " + /n + Medlem.getNavn +  );
		//System.out.println();
} 
		//Lag en ekstra metode for utskrift til skjerm av 
		//alle medlemsdata for dette formålet. 

