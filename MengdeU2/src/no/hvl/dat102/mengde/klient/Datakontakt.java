package no.hvl.dat102.mengde.klient;

public class Datakontakt {
	
	private int antallMedlemmer;
	private Medlem[] medlemTab;
	
	public Datakontakt() {
		medlemTab = new Medlem[100];
		antallMedlemmer = 0;
	}
	
	//LEgger til et nytt medlem i medlemstabellen
	public void leggTilMedlem (Medlem person) {
		
	
			
	}
	//Finner indeks til medlemet i medlemstabellen, dersom medlemmet
	//er registrert eller returnerer indeks lik -1.
	public int finnMedlemsIndeks (String medlemsnavn) {
		for (int i = 0; i < antallMedlemmer; i++) {
			if (medlemTab[i].getNavn() == medlemsnavn)
				return medlemTab[i].getStatusIndeks();
		}
		return -1;
	}
	//Finner ut om et medlem (identifisert med medlemsnavn) passer med et anna
	//medlem, (dersom det finnes) i medlemstabellen. dette medlemmet skal være
	//det første som passer og ikke er "koblet". meotden oppdaterer medtabellen
	//dersom den finner en partner, og returnere eventuell indeks til partneren 
	//i medlemstabellen (eller -1)
	public int finnPartnerFor(String medlemsnavn) {
		if (finnMedlemsIndeks(medlemsnavn) == -1)
			return -1;
		Medlem m1 medlemTab[finnMedlemIndex(medlemsnavn)];
		for (int i = 0; i < antallMedlemer; i++) {
			if (m1.equals(medlemTab[i]) == false && m1.getHobbyer().equals(medlemTab[i].getHobbyer()))
				return i;
		}
		return -1;
	}
	//oppdatere medlemstabellen. Dersom medlemmet finnes og har en partner
	//så brytes koblingen dvs. begge får statusindeks -1.
	public void tilbakestillStausIndeks(String medlemsnavn) {
		
	}

}
