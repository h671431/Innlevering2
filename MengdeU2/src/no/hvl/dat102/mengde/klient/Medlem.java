package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class Medlem {
	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndeks; 

	public Medlem(String navn, MengdeADT<Hobby> hobbyer, int statusIndeks) {
		this.navn = navn;
		this.hobbyer = hobbyer;
		this.statusIndeks = -1;
	}
	public Medlem(String navn, MengdeADT<Hobby> hobbyer) {
		this.navn = navn;
		this.hobbyer = new KjedetMengde<>();
		this.hobbyer.leggTilAlle(hobbyer);;
		this.statusIndeks = -1;
	}
	public Medlem(String navn) {
		this.navn = navn;
		this.hobbyer = new KjedetMengde<>();
		this.statusIndeks = -1;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getStatusIndeks() {
		return statusIndeks;
	}

	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}

	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}

	public void setHobbyer(MengdeADT<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}

	public boolean passerTil(Medlem medlem2) {
		boolean passer = false;
		if (this.getHobbyer() == medlem2.getHobbyer()) {
			passer = true;
		}
		return passer;
	}

}
