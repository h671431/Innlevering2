package no.hvl.dat102.mengde.kjedet;

 
import java.util.Iterator;
import java.util.Random;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.MengdeADT;

public class KjedetMengde<T> implements MengdeADT<T> {
	private static Random rand = new Random();
	private int antall; // antall elementer i mengden
	private LinearNode<T> start;
	//hei, kan du ses dette????

	//Oppretter en tom mengde.
	public KjedetMengde() {
		antall = 0;
		start = null;
	}//

	@Override
	public void leggTil(T element) {
		if (!(inneholder(element))) {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNeste(start);
			start = node;
			antall++;
		}
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.iterator();
		while (teller.hasNext()) {
			this.leggTil(teller.next());
		}
	}

	@Override
	public T fjernTilfeldig() {
		if (erTom())
			throw new EmptyCollectionException("mengde");

		LinearNode<T> forgjenger, aktuell;
		T resultat = null;

		int valg = rand.nextInt(antall) + 1;
		if (valg == 1) {
			resultat = start.getElement();
			start = start.getNeste();
		} else {
			forgjenger = start;
			for (int nr = 2; nr < valg; nr++) {
				forgjenger = forgjenger.getNeste();
			}
			aktuell = forgjenger.getNeste();
			resultat = aktuell.getElement();
			forgjenger.setNeste(aktuell.getNeste());
		}
		antall--;

		return resultat;

	}

	@Override
<<<<<<< HEAD
	public T fjern(T element) { // Denne skal vi se p� litt senere
=======
	public T fjern(T element) { 
>>>>>>> branch 'master' of https://github.com/h671431/Innlevering2.git

		if (erTom())
			throw new EmptyCollectionException("mengde");

		boolean funnet = false;
		LinearNode<T> forgjenger, aktuell;
		T resultat = null;
		if (start.getElement().equals(element)) {// Sletter foran
			resultat = start.getElement();
			start = start.getNeste();
			antall--;
		} else {// Gjennomg�r den kjedete strukturen
			forgjenger = start;
			aktuell = start.getNeste();
			for (int sok = 2; sok <= antall && !funnet; sok++) {
				if (aktuell.getElement().equals(element))
					funnet = true;
				else {
					forgjenger = aktuell;
					aktuell = aktuell.getNeste();
				}
			}
			if (funnet) {
				resultat = aktuell.getElement();
				forgjenger.setNeste(aktuell.getNeste()); // Slette midt inni/bak
				antall--;
			}
		}
		return resultat;

	}//

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		LinearNode<T> aktuell = start;
		for (int soek = 0; soek < antall && !funnet; soek++) {
			if (aktuell.getElement().equals(element)) {
				funnet = true;
			} else {
				aktuell = aktuell.getNeste();
			}
		}
		return funnet;
	}
	/*
	 * N�r vi overkj�rer (override) equals- meteoden er det anbefalt at vi ogs�
	 * overkj�rer hashcode-metoden da en del biblioteker bruker hascode sammen med
	 * equals. Vi kommer tilbake til forklaring og bruk av hashcode senere i faget.
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + antall;
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object ny) {

		if (this == ny) {
			return true;
		}
		if (ny == null) {
			return false;
		}
		if (getClass() != ny.getClass()) {
			return false;
		}
		boolean likeMengder = true;
		MengdeADT<T> m2 = (KjedetMengde<T>) ny;
		if (this.antall != m2.antall()) {
			likeMengder = false;
		} else {
			Iterator<T> teller = m2.iterator();
			while (teller.hasNext() && likeMengder) {
					T element = teller.next();
					if(!this.inneholder(element)) {
						likeMengder = false;
					}
					
				}

		}
		return likeMengder;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) { // Denne ersattes med en mer effektiv union, se kladdeoppgavenr3
		KjedetMengde<T> begge = new KjedetMengde<T>();
		LinearNode<T> aktuell = start;
		while (aktuell != null) {
			begge.leggTil(aktuell.getElement());
			aktuell = aktuell.getNeste(); // this-mengden
		} // while
		Iterator<T> teller = m2.iterator();
		while (teller.hasNext()) {
			begge.leggTil(teller.next());
		}
		return begge;
	}//

	public MengdeADT<T> union (MengdeADT<T> m2) { 
		MengdeADT<T> begge = new KjedetMengde<T>();
		LinearNode<T> aktuell = start;
		T element = null;
		
		while(aktuell != null) {
			((KjedetMengde<T>) begge).settInn(aktuell.getElement());
			aktuell = aktuell.getNeste();
		}
		Iterator<T> teller =m2.iterator();
		while(teller.hasNext()) {
			element = teller.next();
			if(!this.inneholder(element)) {
				((KjedetMengde<T>)begge).settInn(element);
			}
		}
		return begge;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) {
		
		MengdeADT<T> snittM = new KjedetMengde<T>();
		LinearNode<T> aktuell = start;
		while (aktuell != null) {
			if(m2.inneholder(aktuell.getElement())) {
				snittM.leggTil(aktuell.getElement());
			}
			aktuell = aktuell.getNeste();
		}
		return snittM;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {
		
		MengdeADT<T> differensM = new KjedetMengde<T>();
		LinearNode<T> aktuell = start;
		while (aktuell != null) {
			if(m2.inneholder(aktuell.getElement()) == false) {
				differensM.leggTil(aktuell.getElement());
			}
			aktuell = aktuell.getNeste();
		}
		//ny kode forslag
		//Jeg antar at differens er this-mengden minus m2-mengden?
		//fortsetter å bruke differensM mengden over fordi eg orker ikke å lage ny og inser at det hadde tatt meg mindre tid å lage ny enn å skrive alt dette, okei no begynner det e bli teit, koffor leser du enda? du er klar over at jeg har gjort denne ekstra lang for aat du skal komme lenger og lenger til siden bare for min egen underholdning? Dette startet egentlig som en spøk, men jeg inser at du ikke gir deg helt enda som er ganske imponerende o7

		Iterator<T> teller = this.iterator();
		while(teller.hasNext()) {
			T element = teller.next();
			if(!m2.inneholder(element)) {
				differensM.leggTil(element);
			}
		}
		// denne koden kommer til å breake nå pga 2 versjoner av samme stufsa. 
		return differensM;
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {
		
		boolean erUnderMengde = true;
		LinearNode<T> aktuell = start;
		while (aktuell != null){
			if (m2.inneholder(aktuell.getElement()) ==false) {
				erUnderMengde = false;
				break;
			}
			aktuell = aktuell.getNeste();
		}
		return erUnderMengde;
	}

	@Override
	public Iterator<T> iterator() {
		return new KjedetIterator<T>(start);
	}

	private void settInn(T element) { // Hjelpemetode
		LinearNode<T> nyNode = new LinearNode<T>(element);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}
	@Override
	public String toString() {
		String resultat = "";
		LinearNode<T> aktuell = start;
		while (aktuell != null) {
			resultat += aktuell.getElement().toString() + "\t";
			aktuell = aktuell.getNeste();
		}
		return resultat;
	}

	@Override
	
	public String toString() {
		String outstring = "[";
		LinearNode<T> aktuell = start;
		while (aktuell != null) {
			outstring += "\" " + aktuell.getElement().toString() +"\"";
			if(aktuell.getNeste() != null) {
				outstring += ", ";
			}aktuell = aktuell.getNeste();
		}
		outstring += "]";
		return outstring;
				
	}
}// class
