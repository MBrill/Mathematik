package Iterationsverfahren.brentSalamin;

import Iterationsverfahren.IterationsVerfahren1D;

/** Implementierung der Berechnung der Nachkommastellen von pi nach
 *  Brent und Salamin.
 * 
 *  <P>Diese Klasse ist von IterationsVerfahren1D abgeleitet. In der
 *  Oberklasse sind alle Funktionen für das Setzen
 *  der Anfangswerte, der maximalen Anzahl der Iterationen
 *  usw. zusammengefasst.
 *  </P>
 */
public class BrentSalamin extends IterationsVerfahren1D {
    /** Variablen für das Verfahren */
    private double a = 1.0, b = 1.0/Math.sqrt(2.0);
    /** 
     * Wert für pi, falls compute aufgerufen wurde
     * Sonst steht hier p=0.
     */
    private double p = 0.0,
    		        s = 0.5,
    		        c = 0.5,
    		        powerOfTwo = 2.0;     
    
	/**
	 * Default-Konstruktor
	 *
     * Startwerte a=1, b=1/sqrt(2)
     * Abbruchgenauigkeit:              0.005
     * Maximale Anzahl der Iterationen: 10
	 */
	public BrentSalamin() {
		super(0.005, 10);
	}

	/**
	 * Konstruktor mit Abbruchgenauigkeit und maximaler
	 * Anzahl der Iterationen.
	 */
	public BrentSalamin(double eps, int max) {
		super(eps, max);
	}
	
    /** Das Ergebnis für Brent-Salamin steht nicht in a und b, sondern
     *  in der Variable p.
     */
    public double getPi() {
    	return p;
    }
    
	/** Implementierung der Berechnung von pi nach Brent und Salamin */    
	@Override
	public void computeIteration() {
    	double aalt, balt;

   		aalt = this.a;
   		balt = this.b;
   		this.a = 0.5*(aalt+balt);
   		this.b = Math.sqrt(aalt*balt);
   		this.c = this.a*this.a - this.b*this.b;
   		this.s -= this.powerOfTwo*this.c;
   		this.powerOfTwo *=2.0;
   		p = 2.0*this.a*this.a/this.s;		
   		
        if(Math.abs(this.a - this.b) < this.getEpsilon())
            this.stop();  
	}
}
