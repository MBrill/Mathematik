/**
 * Realisierung der Mid-Square Methode von John von Neumann f�r zweistellige Dezimalzahlen
 */
public class VonNeumann {
	/** 
	 * Default Konstruktor
	 * 
	 * Startwert: 5
	 */
	public VonNeumann() {
		x = 5;
	}
	
	/**
	 * Konstruktor mit Startwert
	 * 
	 * @param seed Startwert f�r die Generierung der Zufallszahlen
	 */
	public VonNeumann(int seed) 
	{
		x = seed;
	}
	
	/**
	 * N�chster Wert
	 * Folgender Algorithmus wurde von von Neumann vorgeschlagen:
	 * Quadriere die zweistellige Zahl x und verwende als n�chste
	 * Zahl die beiden mittleren Stellen.
	 * 
	 * Beispiel: x = 43 ==> q = 1849 ==> x = 84. 
	 * @return n�chste "Zufallszahl"
	 */
	public int next() {
        compute();
		return x;
	}
	
	/**
	 * Startwert neu setzen
	 * 
	 * @param seed Startwert f�r die Generierung der Zufallszahlen	 * 
	 */
	public void setSeed(int seed) {
		x = seed;
	}
	
	/**
	 * Berechnen einer weiteren Zahl
	 * 
	 * @return Die private Variable x enth�lt eine weitere "Zufallszahl"
	 */
	private void compute() {
		int t;
		// Quadrieren
		t = x*x;
		// Tausenderstelle weg dividieren
		t = t % 1000;
		t -= (t % 10);
		x = t/10;	
	}
	
	/** 
	 * Variable mit der aktuellen Zahl 
	 */
    private int x;
}
