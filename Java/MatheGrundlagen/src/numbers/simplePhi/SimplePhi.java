package numbers.simplePhi;

import java.util.*;
import java.io.*;

/**
 * Naive Implementierung der Berechnung der Phi-Funktion.
 *
 * In SimplePhi.in wird das Argument für die Berechnung angegeben.
 * In SimplePhi.out steht das Ergebnis der Berechung phi(n).
 *
 * Wir verwenden den Euklidischen Algorithmus, der in der privaten
 * Funktion gcd implementiert ist.
 *
 * @author Manfred Brill
 */
public class SimplePhi 
{
	public static void main(String[] args) throws IOException
	{
		Scanner input = null;
		PrintStream output = null;
		int n;
		
		try {
			input = new Scanner(new File("SimplePhi.in"));
			output = new PrintStream(new File("SimplePhi.out"));


		    n = input.nextInt();

            output.println(phi(n));


		} finally {
			if (input != null) input.close();
			if (output != null) output.close();
		}
	}

	static private int gcd(int a, int b)
	{
		int r;
		while (b != 0)
		{
			r = a%b;
			a = b;
			b = r;
		}
		return a;
	}
	
	static private int phi(int n)
	{
	   int i, result = 1;
	   for (i=2; i<n; i++)
	       if (gcd(n,i)==1) 
	       {
	           result++;
	       }
	   return result;
    }
}


