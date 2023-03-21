package no.hvl.dat102.oppg4;

public class C {

	public static void main(String[] args) {
		for(int i = 0; i < 20; i++) {
			System.out.println(f(i));
		}
	}
	
	static int f(int n) {
		if(n == 0) {
			return 0;
			
		}else if (n == 1) {
			return 1;
		}else {
			return f(n-1) + f(n-2);

		}
	}
}
