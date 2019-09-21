/**
 * @author Manfred Brill
 * Java-Source-Code zur Aufgabe sumprod7.tex
 * Summen als Näherungen von Zahlen
 */
public class Sumprod7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int n=50;
		System.out.println("Der Summenwert S_a = " + summea(n));
		System.out.println("Abstand zwischen S_a und ln(2) = " + Math.abs(summea(n) - Math.log(2.0)));			
		n=20;
		System.out.println("Der Summenwert S_b = " + summeb(n));
		System.out.println("Abstand zwischen S_b und 2.0 = " + Math.abs(summeb(n) - 2.0));		
		n=50;
		System.out.println("Der Summenwert S_c = " + summec(n));
		System.out.println("Abstand zwischen S_c und pi*pi/6 = " + Math.abs(summec(n) - Math.PI*Math.PI/6.0));
        n=40;
		System.out.println("Der Summenwert S_d = " + summed(n));
		System.out.println("Abstand zwischen S_c und 0.5 = " + Math.abs(summed(n) - 0.5));        
	}
	
	// Die Summe a)
	static private double summea(int n)
	{
		double summe = 0.0, vorzeichen = 1.0;
        for (int k=1; k<=n; k++)
        {
        	summe += vorzeichen * 1.0/(double)k;
        	vorzeichen *= -1.0;
        }        
		return summe;
	}	
	
	// Die Summe b)
	static private double summeb(int n)
	{
		double summand = 1.0,
			   summe = summand;
        for (int k=2; k<=n; k++)
        {
        	summand *= 0.5;
        	summe += summand;
        }        
		return summe;
	}
	
	// Die Summe c)
	static private double summec(int n)
	{
		double summe = 0.0;
        for (int k=1; k<=n; k++)
        {
        	summe += 1.0/((double)k*(double)k);
        }       
		return summe;
	}

	// Die Summe d)
	static private double summed(int n)
	{
		double summe = 0.0;
        for (int k=1; k<=n; k++)
        {
        	summe += 1.0/((double)(2*k-1)*(double)(2*k+1));
        }       
		return summe;
	}	
}
