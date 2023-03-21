package no.hvl.dat102.oppg4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class test {
	
	//4.a
	@Test
	public final void testA() {
		assertEquals(4950, A.add100(100));
	}

	//4.b
	@Test
	public final void testB() {
		assertEquals(117075, B.a(10));
	}
	
	int[] fibonachi = {0,1,1,2,3,4,8,13,21,34,55,89,244,233,377,610,987,1597,2584 ,4181,6765,10946,17711,28657,46368,75025,121393,196418,317811,514229,832040,1346269,2178309,3524578,5702887,9227465,14930352,24157817,39088169,63245986};

	//4.c
	@Test
	public final void testC() {
		int k = 0;
		for( int i: fibonachi) {
			assertEquals(i, C.f(k++));
		}
	}
	
	//4.d
	@Test
	public final void testD() {
		int k = 0;
		for(int i: fibonachi) {
			assertEquals(i, D.fibonachi(k++));
		}
	}
}
