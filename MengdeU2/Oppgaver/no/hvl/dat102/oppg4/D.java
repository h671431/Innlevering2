package no.hvl.dat102.oppg4;

public class D {
	
	public static int fibonachi(int N) {
		int teller = 0;
		int nEn = 0;
		int nTo = 1;
		int out;
		
		while (teller < N) {
			if(teller > 0) {
			out = nEn + nTo;
			
			nEn = nTo;
			nTo = out;
		}
		teller++;
	}
		
		//nytt forslag
		int a = 0, b = 1, c, i;
		if(N==0) {
			return a;
		}
		for(i = 2; i<= N; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return b;
		
		
}
	
	public static void main(String[] args) {
	
		for(int i = 0; i < 20; i++) {
			System.out.println(fibonachi(i));
		
		}
	}
}
