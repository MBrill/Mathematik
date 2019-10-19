package Iterationsverfahren.NullstellenAlgorithmen.regulaFalsi;

import Iterationsverfahren.NullstellenAlgorithmen.NullstellenAlgorithmus;
import Iterationsverfahren.NullstellenAlgorithmen.Function;

/**
 *  Implementierung der Regula Falsi.
 * 
 *  <P>Diese Klasse ist von NullstellenAlgorithmus abgeleitet.</P>
 *  
 *  <P>Diese Klasse implementiert insbesondere die rein virtuelle
 *  Funktion computeIteration.</P>
 */
public class RegulaFalsi extends NullstellenAlgorithmus {

    /**
     * Das Startintervall [a, b]. 
     * Achtung: [a, b] und die Funktion, die wir betrachten
     * sollten die Vorausetzungen des Zwischenwertsatzes
     * erfüllen!
     */
	private double a = 0.0, b = 0.0;
	
	/** 
	 * Aktuelle Schnittstelle der Sekante mit der x-Achse */
	private double xs;

	/**
	 * Variablen für die Durchführung des Verfahrens
	 */
	private double fa, fb, fx;
	
    /**
     * Konstruktor
     * 
     * @param eps Abbruchgenauigkeit Intervalllänge
     * @param eps2 Abbruchgenauigkeit Funktionswert
     * @param max  maximale Anzahl der Iterationen
     * @param links linke Intervallgrenze
     * @param rechts rechte Intervallgrenze
     * @param  func Implementierung des Interface Function;
     *        damit definieren wir die Funktion, für die wir die
     *        Nullstelle suchen.
     */
    public RegulaFalsi(double eps, double eps2, int max, double links, double rechts, Function func) {
    	super(eps, eps2, max, func);	
    	this.a = links;
    	this.b = rechts;
    	
    	xs = 0.0;
	    fa = this.function.call(a);
	    fb = this.function.call(b);
	    fx = Math.min(Math.abs(fa), Math.abs(fb));
	
        if (fa*fb >= 0) {
    	    System.out.println("Regula Falsi: Intervall verletzt den Zwischenwertsatz!");
    	    return;
        }    	
    }
    
	/** 
	 * @return Berechnete Näherung
	 */
	public double getResult() {
		return xs;
	}
		
	public void computeIteration() {
		double xs2 = 0.0;
		
		xs2 = this.xs;
	    xs = (a*fb - b*fa)/(fb - fa);
	    // Funktionswert an der neuen Stelle berechnen
	    fx = this.function.call(xs);
	    if (fa*fx < 0.0) {
		    b = xs;
		    fb = fx;
	    }
	    else {
		    a = xs;
		    fa = fx;
	    }
        if(Math.abs(this.xs - xs2) <= this.getEpsilon() || Math.abs(fx) <= this.epsilon2)
            this.stop(); 	    
	}
}
