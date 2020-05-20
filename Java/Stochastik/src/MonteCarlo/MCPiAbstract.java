/**
 * Basisklasse für Monte-Carlo Methoden zur Bestimmung von Nachkommastellen der irrationalen Zahl pi.
 */
abstract public class MCPiAbstract 
{
	public MCPiAbstract() {}
	
	/**
	 * Durchführung des Monte-Carlo Experiments
	 * 
	 * @param generator Instanz eines Zufallszahlengenerators
	 * @param k Anzahl der Punkte, die im Einheitsquadrat erzeugt werden sollen
	 * 
	 * @return Relative Häufigkeit der Treffer im Einheitskreis
	 */
	protected static int experiment(java.util.Random generator, int k)
	{
		int i, h=0;
		double x, y;
		for (i=0; i<k; i++) {
			x = generator.nextDouble();
			y = generator.nextDouble();			
			if (inArea(x,y))
				h++;
		}
		return h;
	}
	
	/** 
	 * Entscheidung, ob ein Punkt im  Einheitskreis liegt 
	 * 
	 * @param x x-Koordinate des Punkts, der überprüft wird
     * @param y y-Koordinate des Punkts, der überprüft wird	 
     * 
     * @return true, falls der Punkt im Einheitskreis liegt
	 */
	protected static boolean inArea(double x, double y)
	{
		return (x*x + y*y <= radius);
	}	
	
	
	/**
	 * Ausgabe der Ergebnisse auf der Konsole
	 * 
	 * @param hK Relative Häufigkeit der Treffer im Einheitskreis
	 * @param p  Berechnete Näherung für pi als double-Zahl
	 */
    public static void printResults(double hK, double p) 
    {
    	double delta = Math.abs(Math.PI - p);
    	
		System.out.println("\nDas Ergebnis unseres Monte-Carlo Experiments");	
		System.out.println("--------------------------------------------");
		System.out.println("Die relative Häufigkeit der Treffer im Einheitskreis: " + hK);
		System.out.println("Unsere Schützung für pi: " + p);
		System.out.println("Der absolute Fehler zwischen Pi und unserer Schätzung: " + delta);
    }
    
	/** Radius */
	static protected double radius = 1.0;
}
