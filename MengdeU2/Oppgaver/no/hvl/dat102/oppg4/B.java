package no.hvl.dat102.oppg4;

public class B {
	public static void main(String[] args) {
		
		System.out.println(a(7));
	}
	
	static int a(int n) {
		if(n == 0) {
			return 2;
			
		}else if(n == 1) {
			return 5;
		}
		return (5*a(n-1)) - (6*a(n-2)) +2;
	}
}
