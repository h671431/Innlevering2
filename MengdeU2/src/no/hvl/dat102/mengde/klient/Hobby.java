package no.hvl.dat102.mengde.klient;

public class Hobby {
	private String hobbyNavn;  
	
	public Hobby(String hobby){ 
		hobbyNavn = hobby; 
	} 
	@Override
	public String toString(){ 
		String resultat = "<" + hobbyNavn + ">";
		return resultat;
	}
	public String getHobbyNavn() {
		return hobbyNavn;
	}
	public void setHobbyNavn(String hobby) {
		this.hobbyNavn = hobby;
	}
	public boolean equals(Object hobby2){  
		// eventuelt fylle ut f�rst med "standard" kode        
		// som vi ofte har med overkj�ring av 
		// equals-metoden generert av Eclipse 
	Hobby hobbyDenAndre = (Hobby)hobby2; 
	return(hobbyNavn.equals(hobbyDenAndre.getHobbyNavn())); 
	} 

}
