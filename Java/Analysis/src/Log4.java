/**
 * 
 */

/**
 * @author Manfred Brill
 * Java-Source-Code zur Aufgabe log4.tex
 * Approximation von ld durch ld(x) = ln(x) + log(x)
 */
public class Log4 
{
	public static void main(String[] args) 
	{
		double x = 0.5,
			   delta = 0.1;
		
		System.out.println("Approximation des logarithmus dualis");
		
		System.out.println("x-Wert    ln(x)+log10(x)        ln(x)/ln(2)");
		while (x <= 2.5)
		{
			System.out.println(x + "  " + approx(x) + "  " + ld(x));
			x += delta;
		}

	}
	
	// Konstante für ln(2.0)
	static private double ln2 = Math.log(2.0);
	
	// Die Approximationsformel aus der Aufgabe
	static private double approx(double x)
	{
	     return Math.log(x) + Math.log10(x);
	}
	
	// Approximation von ld durch ln(x)/ln(2.0)
	static private double ld(double x)
	{
	return Math.log(x)/ln2;
	}

}
