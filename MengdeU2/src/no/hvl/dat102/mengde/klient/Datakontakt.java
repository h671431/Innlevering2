package no.hvl.dat102.mengde.klient;

public class Datakontakt {
	
	private int antallMedlemmer;
	private Medlem[] medlemTab;
	
	public Datakontakt() {
		int maksMengde = 100;
		medlemTab = new Medlem[maksMengde];
		antallMedlemmer = 0;
	}
	public int getAntallMedlemmer() {
		return antallMedlemmer;
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
		}
		medlemTab[antallMedlemmer + 1] = person;
		antallMedlemmer++;
	
			
	}
	public int finnMedlemsIndeks (String medlemsnavn) {
//		for (int i = 0; i < antallMedlemmer; i++) {
//			if (medlemTab[i].getNavn() == medlemsnavn)
//				return medlemTab[i].getStatusIndeks();
//		}
//		return -1;
		//nytt forslag til kode
		for(int i = 0; i < antallMedlemmer; i++) {
			//antar mengden starter på 0, returnerer index posisjonen til medlemet
			if(medlemTab[i].equals(medlemsnavn)) {
				return i;
			} else {
				return -1; //ikke funnet;
			}
		}
	}
	public int finnPartnerFor(String medlemsnavn) {
		if (finnMedlemsIndeks(medlemsnavn) == -1)
			return -1;
		Medlem m1 = medlemTab[finnMedlemsIndeks(medlemsnavn)];
		for (int i = 0; i < antallMedlemmer; i++) {
			if (m1.equals(medlemTab[i]) == false && m1.getHobbyer().equals(medlemTab[i].getHobbyer()))
				return i;
		}
		return -1;
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
