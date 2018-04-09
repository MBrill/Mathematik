/**
 * Monte-Carlo Methode zur Bestimmung von pi
 * Aufgabe 3.2 
 */

public class MC_Pi {

	public static void main(String[] args) {
		
		java.util.Random generator = new java.util.Random();
		
		int i, n = 100000000, h=0;
		double x, y, hK, 
		             p, delta,  
		             nD = (double)n;
		
		System.out.println("Annäherung an pi mit Hilfe einer Monte-Carlo Simulation");		
		System.out.println("Wir beginnnen mit der Simulation!");
		System.out.println("Wir werfen " + n + "-mal!");
		System.out.println("Bitte etwas Geduld!");
		System.out.println("Sobald die Simulation beendet ist erfolgt wieder eine Ausgabe auf der Konsole!");
		
		for (i=0; i<n; i++) {
			x = generator.nextDouble();
			y = generator.nextDouble();			
			if (inArea(x,y))
				h++;
		}

		hK = (double)h/nD;
		p = 4.0 * hK;
		delta = Math.abs(Math.PI - p);
		
		System.out.println("\nDas Ergebnis unseres Monte-Carlo Experiments");	
		System.out.println("--------------------------------------------");
		System.out.println("Die relative Häufigkeit: " + hK);
		System.out.println("Unsere Schäzung für pi: " + p);
		System.out.println("Der absolute Fehler zwischen Pi und unserer Schätzung: " + delta);

	}
	
	/** 
	 * Entscheidung, ob ein Punkt im  Einheitskreis liegt 
	 * 
	 * @param x x-Koordinate des Punkts, der überprüft wird
     * @param y y-Koordinate des Punkts, der überprüft wird	 
     * 
     * @return true, falls der Punkt im Einheitskreis liegt
	 */
	private static boolean inArea(double x, double y)
	{
		return (x*x + y*y <= radius);
	}	
	
	private static double radius = 1.0;
}
