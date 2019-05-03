/**
 *   Implementierung des Euklidischen Algorithmus
 */
public class Euklid 
{
	/** Defaultkonstruktor, beide Zahlen a und b sind 1 */
	public Euklid() {
		this.a = 1;
		this.b = 1;
	}
	
	/** 
	 * Konstruktor mit den beiden Zahlen a und b.
	 * Falls das Argument aa kleiner als bb ist, werden
	 * die Werte getauscht!
	 */
	public Euklid(long aa, long bb) {
		if (aa > bb) {
			this.a = aa;
			this.b = bb;
		}
		else {
			this.a = bb;
			this.b = aa;
		}		
	}
	
	/**
	 * Euklidischer Algorithmus
	 * 
	 * @return größter gemeinsamer Teiler von a und b
	 */
	public long gcd()
	{
		long r;
		long localA = this.a, localB = this.b;
		while (localB != 0)
		{
			r = localA%localB;
			localA = localB;
			localB = r;
		}
		return localA;
	}

	/**
	 * Verallgemeinerter Euklidischer Algorithmus
	 * 
	 * @return Feld mit dem Ergebnis der Berechnung:
	 *         result[0] * a + result[1] * b = result[2].
	 *         Also ist insbesondere ggT(a, b) = result[2].
	 */	
	public long[] extendedGcd()
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
	
	/** Variablen a und b für die Berechnung von ggT(a, b) */
	private long a, b;	
}

