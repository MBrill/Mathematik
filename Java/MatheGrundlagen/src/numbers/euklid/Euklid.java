package numbers.euklid;
import java.io.*;
import java.util.*;

/*!
 *   Implementierung des Euklidischen Algorithmus
 */
public class Euklid 
{
	/**
	 * Hauptprogramm
	 * 
	 * Wir lesen die beiden  Zahlen a und b, für die der
	 * Algorithmus durchgeführt werden soll aus der Datei
	 * Euklid.in ein und führen den Algorithmus durch.
	 * 
	 * Das Ergebnis steht in der Datei Euklid.out.
	 * @param args Nicht verwendet
	 * @throws IOException Exception bei Dateien
	 */
	public static void main(String[] args) throws IOException
	{
		Scanner scanner = null;
		PrintStream out = null;
		long a, b, result;
		
		try {
			scanner = new Scanner(new File("Euklid.in"));
			out = new PrintStream(new File("Euklid.out"));

			a = 0;
			b = 0;
			while (scanner.hasNextInt()) {
				 a = scanner.nextInt();
				 b = scanner.nextInt();
			}
			result = gcd(a,b);

			out.println("a = " + a + " , b = " + b);
			out.println("ggT(a,b) = " + result);

			System.out.println("Success!");

			out.println(" ");
			out.println("Jetzt mit dem Extended Algorithm");
			long[] res = extendedGcd(a,b);

			out.println("a = " + a + " , b = " + b);
			out.println("ggT(a,b) = " + res[2]);
			out.println("Es gilt " + res[0] + " * " + a + " + " + res[1] + " * " + b + " = " + res[2]);
			System.out.println("Success again!");
		} finally {
			if (scanner != null) scanner.close();
			if (out != null) out.close();
		}
	}

	static private long gcd(long a, long b)
	{
		long r;
		while (b != 0)
		{
			r = a%b;
			a = b;
			b = r;
		}
		return a;
	}
	
	/**
	 * Verallgemeinerter euklidischer Algorithmus.
	 * 
	 * Mit dieser Funktion können wir diophantische Gleichungen lösen.
	 * 
	 * @param a Koeffizient der Gleichung
	 * @param b Koeffizient der Gleichung
	 * @return Lösungen der Gleichung in Array
	 */
	static private long[] extendedGcd(long a, long b)
	{
		long[] result = new long[3];
		long q, u1, u2, u3, s1, s2, s3, t1, t2, t3;
		s1 = 1;
		s2 = 0;
		s3 = a;
		t1 = 0;
		t2 = 1;
		t3 = b;

		while (t3 !=0)
		{    
			q =  s3/t3;
			u1 = s1 - q*t1;
			u2 = s2 - q*t2;
			u3 = s3 - q*t3;

			s1 = t1;
			s2 = t2;
			s3 = t3;
			t1 = u1;
			t2 = u2;
			t3 = u3;
		}
		result[0] = s1;
		result[1] = s2;
		result[2] = s3;
		return result;
	}
}


