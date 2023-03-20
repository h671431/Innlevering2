package no.hvl.dat102.mengde.tabell;

public class TabellMengdeTest {

	public static void main(String[] args) {
		TabellMengde<String> m1 = new TabellMengde<String>(4);
		TabellMengde<String> m2 = new TabellMengde<String>(6);
		TabellMengde<String> union = new TabellMengde<String>(8);
		TabellMengde<String> snitt = new TabellMengde<String>(3);
		TabellMengde<String> differens = new TabellMengde<String>(7);
		TabellMengde<String> undermengde = new TabellMengde<String>(3);

		m1.leggTil("Bodil");
		m1.leggTil("Einar");
		m1.leggTil("Leo");
		m1.leggTil("Luna");

		m2.leggTil("Lydia");
		m2.leggTil("Leo");
		m2.leggTil("Hanne");
		m2.leggTil("Marte");
		m2.leggTil("Martin");
		m2.leggTil("Mons");

		union.leggTil("Leo");
		union.leggTil("Kåre");
		union.leggTil("Ole");
		union.leggTil("Mons");
		union.leggTil("Kristian");
		union.leggTil("Anila");
		union.leggTil("Hans");
		union.leggTil("Nils");

		snitt.leggTil("Marte");
		snitt.leggTil("Ole");
		snitt.leggTil("Lydia");

		differens.leggTil("Ole");
		differens.leggTil("Hanne");
		differens.leggTil("Kristian");
		differens.leggTil("Line");
		differens.leggTil("Anna");
		differens.leggTil("Kåre");
		differens.leggTil("Mats");
		
		undermengde.leggTil("Hanne");
		undermengde.leggTil("Bodil");
		undermengde.leggTil("Mons");

		System.out.println("M1: " + m1.toString());
		System.out.println("M2: " + m2.toString());

		//Teste union
		if (m1.union(m2).equals(union)) {
			System.out.println("\nUnion funka: ");
			System.out.println(union.toString());
		} else {
			System.out.println("\nUnion funka ikkje");
		}
		//Teste snitt
		if (m1.snitt(m2).equals(snitt)) {
			System.out.println("\nSnitt funka: ");
			System.out.println(snitt.toString());
		} else {
			System.out.println("\nSnitt funka ikkje");
		}
		//Teste differensen
		if (m1.differens(m2).equals(differens)) {
			System.out.println("\nDifferansen funka: ");
			System.out.println(differens.toString());
		} else {
			System.out.println("\nDifferansen funka ikkje");
		}
		//Teste undermengden
		if (m1.undermengde(undermengde)) {
			System.out.println("\nUndermengde funka: ");
			System.out.println(undermengde.toString());
		} else {
			System.out.println("\nUndermengde funka ikkje");
		}
	}

}
