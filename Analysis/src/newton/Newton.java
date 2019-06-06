package analysis.newton;

import analysis.NullstellenAlgorithmus;
import analysis.Function;

/**
 *  Implementierung des Newton-Verfahrens.
 * 
 *  <P>
 *  Diese Klasse ist von NullstellenAlgorithmus abgeleitet.
 *  In dieser Basisklasse ist eine Instanz von Function
 *  vorhanden, die für die Funktionsauswertung verwendet wird.
 *  Das Newton-Verfahren benötigt darüber hinaus die Ableitung, die
 *  in dieser Klasse vereinbart ist. Das Verfahren wird in der 
 *  Funktion computeIteration implementiert.</P>
 *  
 * <p>Letzte Änderung: $Date: 2014/08/05 $</p>
 * 
 * @author $Author: brill $
 * @version $Revision: #3 $
 */
public class Newton extends NullstellenAlgorithmus {
	
	
	/** 
	 * Die aktuelle Näherung.
	 */
	private double xn = 0.0;

	/**
	 * Variablen für den Funktionswert an der aktuellen Näherung
	 * und die Ableitung an dieser Stelle.
	 */
	private double  fx = 0.0, 
	                fxprime = 0.0;
	
	/**
	 * Die Funktion für die Ableitung
	 */
	private Function derivative;

    /**
     * Konstruktor
     * 
     * @param eps Abbruchgenauigkeit Intervalllänge
     * @param eps2 Abbruchgenauigkeit Funktionswert
     * @param max  maximale Anzahl der Iterationen
     * @param x0 Startwert für den Algorithmus
     * @param  func Implementierung des Interface Function;
     *              damit definieren wir die Funktion, für die wir die
     *              Nullstelle suchen.
     * @param  deriv Implementierung des Interface Function;
     *               damit definieren wir die Ableitung der Funktion, für die wir die
     *               Nullstelle suchen.        
     */
    public Newton(double eps, double eps2, int max, double x0, Function func, Function deriv) {
    	super(eps, eps2, max, func);	
    	this.xn = x0;
    	this.derivative = deriv;
    	
	    this.fx = this.function.call(this.xn);
	    this.fxprime = this.derivative.call(this.xn);	
    }
    
	/** 
	 * @return Berechnete Näherung zurückgeben
	 */
	public double getResult() {
		return xn;
	}
	
	/**
	 * Durchführung einer Iteration des Newton-Verfahrens.
	 * 
	 * @see analysis.NullstellenAlgorithmus#computeIteration()
	 */
	@Override
	public void computeIteration() {
		double xold = 0.0;
		
		// Vorherigen Wert speichern für das Abbruchkriterium
    	xold = xn;
    	
    	// Iterationsschritt
	    xn -= fx/fxprime;
	    
	    // Funktionswerte an der neuen Stelle berechnen, für 
	    // den nächsten Schritt
	    this.fx = this.function.call(xn);
	    this.fxprime = this.derivative.call(xn);
	    
        if(Math.abs(this.xn - xold) <= this.getEpsilon() || Math.abs(fx) <= this.epsilon2) {
        	this.stop();
        }
	}
}
