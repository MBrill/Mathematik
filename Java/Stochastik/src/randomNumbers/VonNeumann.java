/**
 * Realisierung der Mid-Square Methode von John von Neumann für zweistellige Dezimalzahlen
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
	 * @param seed Startwert für die Generierung der Zufallszahlen
	 */
	public VonNeumann(int seed) 
	{
		x = seed;
	}
	
	/**
	 * Nächster Wert
	 * Folgender Algorithmus wurde von von Neumann vorgeschlagen:
	 * Quadriere die zweistellige Zahl x und verwende als nächste
	 * Zahl die beiden mittleren Stellen.
	 * 
	 * Beispiel: x = 43 ==> q = 1849 ==> x = 84. 
	 * @return nächste "Zufallszahl"
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
	 * @return Die private Variable x enthält eine weitere "Zufallszahl"
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