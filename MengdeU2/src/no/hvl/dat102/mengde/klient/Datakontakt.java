package no.hvl.dat102.mengde.klient;

public class Datakontakt {
	
	private int antallMedlemmer;
	private Medlem[] medlemTab;
	
	public Datakontakt() {
		int maksMengde = 100;
		medlemTab = new Medlem[maksMengde];
		antallMedlemmer = 0;
	}
	
	public Medlem[] getMedlemTab() {
		return medlemTab;
	}
	
	public int getAntallMedlemmer() {
		return antallMedlemmer;
	}
	public Medlem getMedlem(String medlemsnavn) {
		int m = finnMedlemsIndeks(medlemsnavn);
		Medlem medlem = null;
		if(m != -1) {
			medlem = medlemTab[m];
		}
		
		return medlem;
	}
	
	//LEgger til et nytt medlem i medlemstabellen
	public void leggTilMedlem (Medlem person) {
		//person.setStatusIndeks(antallMedlemmer);
		//medlemTab[antallMedlemmer++] = person;
		//forslag ny koden
		//burde kanskje ha noe som sjekker om vi nærmer oss maks antal medlemmer. men det er en eksklusiv klubb så de kan ikke ha mer en 100 medlemmer.
		if(antallMedlemmer == 0) {
			medlemTab[0] = person;
			antallMedlemmer ++;
		} else {
		medlemTab[antallMedlemmer] = person;
		antallMedlemmer++;
		}
	}
	public int finnMedlemsIndeks (String medlemsnavn) {
		int indeks = -1;
		boolean funnet = false;
		
		for (int i = 0; i < medlemTab.length && !funnet; i++) {
			if (medlemTab[i].getNavn().equals(medlemsnavn)) {
				indeks = i;
				funnet = true;
			}
		}
		
		return indeks;
	}	
	public Medlem finnMedlem (int medlemsIndex) {
		
		
		return medlemTab[medlemsIndex];
	}	
    
	public String finnPartnerFor(String medlemsnavn) {
		/*boolean funnet = false;
		int m1 = finnMedlemsIndeks(medlemsnavn);
		int m2 = -1;
		int indeks = -1;
		for (int i = 0; i < antallMedlemmer && !funnet; i++) {
			m2 = i;
			if((medlemTab[m2].passerTil(medlemTab[m1]) && medlemTab[m2].getStatusIndeks() == -1) && m1 != m2) {
				medlemTab[m2].setStatusIndeks(m1);
				medlemTab[m1].setStatusIndeks(m2);
				indeks = m2;
				funnet = true;
			} 
		}
		return indeks;
	
		if (finnMedlemsIndeks(medlemsnavn) == -1)
			return -1;
		Medlem m1 = medlemTab[finnMedlemsIndeks(medlemsnavn)];
		for (int i = 0; i < antallMedlemmer; i++) {
			if (m1.equals(medlemTab[i]) == false && m1.getHobbyer().equals(medlemTab[i].getHobbyer()))
				return i;
		}
		return -1;*/
		String match = null;
		for(int i = 0; i < antallMedlemmer; i++) {
			if(medlemTab[i].getStatusIndeks() == medlemTab[(finnMedlemsIndeks(medlemsnavn))].getStatusIndeks()) {
				//doo nothing
			}
			else if(medlemTab[i].getHobbyer() == medlemTab[(finnMedlemsIndeks(medlemsnavn))].getHobbyer()) {
				match = medlemTab[i].getNavn();

			}
		}
		return match;
	}
	public void tilbakestillStausIndeks(String medlemsnavn) {
		if (finnMedlemsIndeks(medlemsnavn) == -1 || finnPartnerFor(medlemsnavn) == -1)
			return;
		Medlem m1 = medlemTab[finnMedlemsIndeks(medlemsnavn)];
		Medlem m2 = medlemTab[finnPartnerFor(medlemsnavn)];
		if(m1 != medlemTab[finnPartnerFor(medlemsnavn)]) {
			m1.setStatusIndeks(-1);
			m2.setStatusIndeks(-1);
		}
		
	}

}
