/**
 * Simulation des Tafel-Experiments
 * 
 * Aufgabe 3.1
 */
public class TafelExperiment {

	public static void main(String[] args) {
		
		java.util.Random generator2 = new java.util.Random();
		
		// Wir verwenden eine Tafel mit linker unterer Ecke (0,0), rechte
		// obere Ecke (2,1). A liegt bei x zwischen
		// (0.5, 1.5), in y zwischen 0.5 und 1.0.
		// Die exakte Fl�che f�r A ist dann gegeben als 0.5.
		int i, n = 100000000, h=0;
		double x, y, 
			   area = areaOfA(xmin, xmax, ymin, ymax),
			   hK, a, delta,  
		       nD = (double)n;
		
		System.out.println("Bestimmung einer Rechtsecksfl�che mit Hilfe einer Monte-Carlo Simulation");
		System.out.println("Wir beginnnen mit der Simulation!");
		System.out.println("Wir werfen " + n + "-mal!");
		System.out.println("Bitte etwas Geduld!");
		System.out.println("Sobald die Simulation beendet ist erfolgt wieder eine Ausgabe auf der Konsole!");		
		for (i=0; i<n; i++) {
			x = generator2.nextDouble();
			y = generator2.nextDouble();			
			if ( inArea(x,y))
				h++;
		}

		System.out.println("Die Simulation ist beendet, wir analysieren jetzt die Ergebnisse!");
		hK = (double)h/nD;
		a = 2.0 * hK;
		delta = Math.abs(area - a);
		
		System.out.println("Das Ergebnis unseres Monte-Carlo Experiments\n");	
		System.out.println("Das Verh�ltnis zwischen der exakten Fl�che von A und der Tafel ist " + area/2.0);
		System.out.println("Die relative H�ufigkeit der Treffer in unserer Fl�che A ist " + hK);
		System.out.println("Der exakte Wert f�r die Fl�che von A ist " + area);
		System.out.println("Unsere Sch�tzung f�r die Fl�che A ist " + a);
		System.out.println("Der absolute Fehler zwischen der Fl�che und unserer Sch�tzung ist " + delta);
	}
	
	/** 
	 * Entscheidung, ob ein Punkt im  Einheitskreis liegt 
	 * 
	 * @param x x-Koordinate des Punkts, der �berpr�ft wird
     * @param y y-Koordinate des Punkts, der �berpr�ft wird	 
     * 
     * @return true, falls der Punkt im Einheitskreis liegt
	 */
	private static boolean inArea(double x, double y)
	{
		return ((x>= xmin && x <= xmax)&& (y >= ymin && y <= ymax));
	}	
	
	/**
	 * Berechnung der gesuchten Fl�che
	 * 
	 * @param xmin minimaler x-Wert des Rechtecks A
	 * @param xmax maximaler x-Wert des Rechtecks A
	 * @param ymin minimaler y-Wert des Rechtecks A
	 * @param ymax maximaler y-Wert des Rechtecks A
	 * @return
	 */
	private static double areaOfA(double xmin, double xmax, double ymin, double ymax)
	{
		return ((xmax-xmin)*(ymax-ymin));
	}
	
	/**
	 * Daten f�r die Fl�che A
	 */
	private static double   xmin=0.5, xmax=1.5, 
		                                    ymin=0.5, ymax=1.0;
}
