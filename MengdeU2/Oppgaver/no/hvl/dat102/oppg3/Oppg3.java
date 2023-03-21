package no.hvl.dat102.oppg3;

import java.util.Stack;

public class Oppg3 implements Parentessjekk{

	@Override
	public boolean erVenstreparentes(char p) {
		return (p == '{' || p == '[' || p == '(');
	}
	
	@Override
	public boolean erHogreparentes(char p) {
		return (p == '}' || p == ']' || p == ')');
	}

	@Override
	public boolean erParentes(char p) {
		return erVenstreparentes(p) || erHogreparentes(p);
	}

	@Override
	public boolean erPar(char venstre, char hogre) {
		if(erParentes(venstre) == false || erParentes(hogre)) return false;
		return hogre == finnHogere(venstre);
	}

	@Override
	public boolean erBalansert(String s) {
		Stack<Character> stabel = new Stack<>();
		for(char c : s.toCharArray()) {
			if(erVenstreparentes(c)) {
				stabel.add(c);
			}
			if(erHogreparentes(c)) {
				char v =stabel.pop();
				if(!erPar(v, c)) {
					return false;
				}
			}
		}
		return true;
	}
	
	char finnHogere(char p) {
		switch(p) {
		case('{'):
			return '}';
		case('['):
			return ']';
		case('('):
			return ')';
		
		}
		return ' ';
	}

}
