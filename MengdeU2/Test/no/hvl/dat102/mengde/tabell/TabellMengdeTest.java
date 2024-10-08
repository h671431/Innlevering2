package no.hvl.dat102.mengde.tabell;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class TabellMengdeTest {

	private MengdeADT<Integer> m1;
	private MengdeADT<Integer> m2;

	@Before
	public void setup() {
		m1 = new TabellMengde<Integer>();
		m2 = new TabellMengde<Integer>();

		m1.leggTil(1);
		m1.leggTil(2);
		m1.leggTil(3);
		m1.leggTil(4);
		m1.leggTil(5);
		
		m2.leggTil(4);
		m2.leggTil(5);
		m2.leggTil(6);
		m2.leggTil(7);
		m2.leggTil(8);
	}

	@Test
	public void snitt() {
		assertTrue("Snitt inneholder 4", m1.snitt(m2).inneholder(4));
		assertTrue("Snitt inneholder 5", m1.snitt(m2).inneholder(5));
		assertEquals("Snittet av de to mengdene har lengde 2", 2, m1.snitt(m2).antall());
	}

	@Test
	public void union() {

		assertTrue("Unionen inneholder 1", m1.union(m2).inneholder(1));
		assertTrue("Unionen inneholder 2", m1.union(m2).inneholder(2));
		assertTrue("Unionen inneholder 3", m1.union(m2).inneholder(3));
		assertTrue("Unionen inneholder 4", m1.union(m2).inneholder(4));
		assertTrue("Unionen inneholder 5", m1.union(m2).inneholder(5));
		assertTrue("Unionen inneholder 6", m1.union(m2).inneholder(6));
		assertTrue("Unionen inneholder 7", m1.union(m2).inneholder(7));
		assertTrue("Unionen inneholder 8", m1.union(m2).inneholder(8));

	}

	@Test
	public void differens() {
		assertTrue("Differansemengden mellom en mengde og seg selv er tom.", m1.differens(m1).erTom());
	}
}
