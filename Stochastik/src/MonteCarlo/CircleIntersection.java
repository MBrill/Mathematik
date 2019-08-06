/**
 * Monte-Carlo Methode zur Bestimmung der Fläche des Durchschnitts
 * von zwei Kreisen
 */
public class CircleIntersection {

	public static void main(String[] args) {
		
		java.util.Random generator = new java.util.Random();	
		
		//int i, n = 100, h=0;
		int i, n = 100000, h=0;
		double x, y, hK, 
		       nD = (double)n;
		
		System.out.println("Wir beginnnen mit der Simulation!");
		System.out.println("Wir werfen " + n + "-mal!");
		for (i=0; i<n; i++) {
			x = generator.nextDouble();
			y = generator.nextDouble();			
			if (inArea(x, y)) h++;
		}

		hK = (double)h/nD;
		
		System.out.println("Das Ergebnis unseres Monte-Carlo Experiments");	
		System.out.println("--------------------------------------------");
		System.out.println("Die Schätzung für unsere Fl�che: " + hK);
	
	}
	
	/** 
	 * Entscheidung, ob ein Punkt im Schnitt der beiden Kreise liegt 
	 * 
	 * @param x x-Koordinate des Punkts
	 * @param y y-Koordinate des Punkts
	 * @return true, falls Punkt im Durchschnitt der beiden Kreise liegt
	 */
	private static boolean inArea(double x, double y)
	{
		// Daten �ber die Kreise
		double radius2 = radius* radius;

		
		boolean res1 = false, res2 = false;
		// Punkt im ersten Kreis?
		if ( (x-xm1)*(x-xm1) + (y - ym1)*(y - ym1) <= radius2 ) res1 = true;
		// Punkt im zweiten Kreis?
		if ( (x-xm2)*(x-xm2) + (y - ym2)*(y - ym2) <= radius2 ) res2 = true;
		return (res1 && res2);
	}
	
	/**
	 * x-Koordinate des Mittelpunkts von Kreis 1
	 */
	private static double xm1 = 0.0;
	/**
	 * y-Koordinate des Mittelpunkts von Kreis 1
	 */	
	private static double ym1 = 0.5;
	/**
	 * x-Koordinate des Mittelpunkts von Kreis 2
	 */	
	private static double xm2 = 0.5;
	/**
	 * y-Koordinate des Mittelpunkts von Kreis 2
	 */	
	private static double ym2 = 0.5;
	/**
	 * Radius von Kreis 1 und Kreis 2
	 */
	private static double radius = 0.5;
}
