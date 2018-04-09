/**
 * Realisierung eines linearen Kongruenz-Generators für
 * die Erzeugung von Pseudo-Zufallszahlen.
 *
 *  <P>Ein lineare Kongruenz-Generator benötigt:</P> 
 *  <P>einen Modul m</P>
 *  <P>einen Multiplikator a</P>
 *  <P>ein Inkrement c, und</P> 
 *  <P>einen Startwert ("seed") x_0</P>  
 *  
 *  Lösung der Aufgabe 1.4.
 */
public class LinearCongruentalGenerator {

	/**
	 * Default-Konstruktor
	 *
     * Modul: 100000001
     * Multiplikator: 23
     * Inkrement: 0
     * Startwert: 47594118
     * 
     * Diese Werte sind die von Lehmer verwendeten Werte!
	 */
	public LinearCongruentalGenerator() {	
		m = 100000001L;
		a = 23L;
		c = 0L;
		x0 = 47594118L;
		value = x0;		
	}
	
	/**
	 * Konstruktor mit den vier magischen Zahlen
	 *
     * @param mm Modul
     * @param aa Multiplikator
     * @param cc Inkrement
     * @param x00 Startwert
	 */
	public LinearCongruentalGenerator(long mm, long aa, long cc, long x00) {	
		m = mm;
		a = aa;
		c = cc;
		x0 = x00;
		value = x0;		
	}
	
	/**
	 * Konstruktor mit einem Startwert, alle anderen Größen werden wie der 
	 * Defaultkonstruktor besetzt
	 *
     * @param x00 Startwert
	 */
	public LinearCongruentalGenerator(long x00) {	
		m = 100000001L;
		a = 23L;
		c = 0L;
		x0 = x00;
		value = x0;
	}
	
	/**
	 * Startwert setzen
	 *
	 * @param s Der Startwert ("seed") des Generators
	 */
	public void setSeed(long s) { x0 = s; value = x0; }
	 
	/**
	 * Startwert abfragen
	 * @return der verwendete Startwert ("seed")
	 */
	public long getSeed() { return x0; }
	
	/** 
	 * Den Modul abfragen (die größte Zahl die produziert werden kann ist m-1) 
	 * 
	 * @return Die Zahl abfragen, die als Modul verwendet wird
	 */
	public long getModulus() { return m; }
	
	/** 
	 * Nächste Zufallszahl abfragen
	 * 
	 * @return eine weitere Zufallszahl
	 */
	public long next() {
		 value = (a*value + c) % m;
		 return value;
	}
	
	/** 
	 * Nächste double-Zufallszahl im Intervall [0, 1) abfragen 
	 * 
	 * @return eine weitere Zufallszahl, als Zahl im Einheitsintervall
	 */
	public double nextDouble() {
		value = (a*value + c) % m;
		return (double)value/(double)m;
	}
	
    /** Wert des Moduls */
    private long m; 
    /** Wert des Multiplikators */
    private long a;
    /** Wert des Inkrements */     
    private long c;
    /** Startwert (seed) */
    private long x0;
    /** Wert für die Berechnung */
    private long value;
}
