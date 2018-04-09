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
		System.out.println("Die Schätzung für unsere Flache: " + hK);
	
	}
	
	/** Entscheidung, ob ein Punkt im Schnitt der beiden Kreise liegt */
	private static boolean inArea(double x, double y)
	{
		// Daten über die Kreise
		double radius = 0.5;
		double radius2 =  radius* radius;
		double xm1 = 0.0;
		double ym1 = 0.5;
		double xm2 = 0.5;
		double ym2 = 0.5;		
		
		boolean res1 = false, res2 = false;
		// Punkt im ersten Kreis?
		if ( (x-xm1)*(x-xm1) + (y - ym1)*(y - ym1) <= radius2 ) res1 = true;
		// Punkt im zweiten Kreis?
		if ( (x-xm2)*(x-xm2) + (y - ym2)*(y - ym2) <= radius2 ) res2 = true;
		return (res1 && res2);
	}
}
