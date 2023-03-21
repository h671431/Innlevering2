package no.hvl.dat102.oppg4;

public class A {
	public static void main(String[] args){
		System.out.println(add100(100));
	}
	static int add100(int n) {
		int sum = 0;
		if(n == 100) {
			return sum;
		}
		sum = n + add100(n-1);
		return sum;
		
	}
}
