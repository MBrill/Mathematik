package Iterationsverfahren.NullstellenAlgorithmen.bisektion;

import Iterationsverfahren.NullstellenAlgorithmen.NullstellenAlgorithmus;

//Interface Function für die Funktion, für die wir die Nullstelle suchen 
import Iterationsverfahren.NullstellenAlgorithmen.Function;

/**
 *  Implementierung des Bisektionsverfahrens.
 * 
 *  Diese Klasse ist von NullstellenAlgorithmus abgeleitet.
 *  
 *  Diese Klasse implementiert insbesondere die rein virtuelle
 *  Funktion computeIteration.
 */
public class Bisektion extends NullstellenAlgorithmus {
	
    /**
     * Das Startintervall [a, b]. 
     * Achtung: [a, b] und die Funktion, die wir betrachten
     * sollten die Vorausetzungen des Zwischenwertsatzes
     * erfüllen!
     */
	private double a = 0.0, b = 0.0;
	/**
	 * Weitere Variablen für die Durchführung des Verfahrens
	 */
	private double result = 0.0, 
			        dx = 0.0, 
			        fmid = 0.0, 
			        f = 0.0;
	/** 
     * Aktueller Mittelpunkt des Intervalls. Wird auch als Näherung
     * zurück gegeben.
     */
    private double xmid = 0.0; 
    
    /** Defaultkonstruktor **/
    public Bisektion() {}
    /**
     * Konstruktor
     * 
     * @param eps     Abbruchgenauigkeit
     * @param eps2    Genauigkeit für den Vergleich von f(x) auf 0
     * @param maxIter Maximale Anzahl der Iterationen
     * @param a linke Intervallgrenze a
     * @param b rechte Intervallgrenze b
     */
    public Bisektion(double eps, double eps2, int maxIter, double a, double b, Function func) {
        super(eps, eps2, maxIter, func);
        this.a = a;
        this.b = b;
        
        // Die Iteration vorbereiten
 	    f = function.call(a);
 	    fmid = function.call(b);
 	
        if (f*fmid >= 0) {
     	       System.out.println("c");
        }
     
        // Orientieren, je nachdem wie die Funktionswerte sind
        if (f < 0) {
     	      this.result = this.a;
     	      this.dx = b - this.a;
        }
        else {
        	  this.result = this.b;
        	  this.dx = a - this.b;
        }        
    }
       
    /**
     * Die Intervallteilung durchführen
     */
    @Override
    public void computeIteration() {
    	double xmid2 = 0.0;
    	
 	    // Schrittweite halbieren
 	    dx = 0.5*this.dx;
 	    // Neue Näherung, und vorherige sichern
 	    xmid2 = this.xmid;
 	    xmid = this.result + this.dx;
 	    fmid = this.function.call(xmid);  
 	    if (this.fmid <= 0.0) this.result = this.xmid;
 	    
        if(Math.abs(this.xmid - xmid2) <= this.getEpsilon() || Math.abs(fmid) <= this.epsilon2)
            this.stop(); 	    
    }
    
	/** 
	 * @return Berechnete Näherung
	 */
	public double getResult() {
		return xmid;
	}    
}
