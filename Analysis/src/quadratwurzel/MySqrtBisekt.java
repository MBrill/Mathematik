/**
 * Numerische Berechnung der Quadratwurzel einer reellen Zahl r 
 * auf der Basis der Bisektion.
 * 
 * Wir lösen die Gleichung
 * x^2 - r = 0.
 * 
 * @author Manfred Brill
 * @version $Revision: #1 $
 * $Date: 2013/07/11 $ * 
 */
public class MySqrtBisekt extends Bisektion {
	
	/**
	 * Default-Werte der Bisektion
	 * Radikant 0.0
	 */
    public MySqrtBisekt() {
    	super();
        rad = 0.0;
    }
    
	/**
	 * Default-Werte der Bisektion
	 * @param r der Radikand, für den die Wurzel bestimmt werden soll
	 * 
	 * r muss positiv sein. Wird eine negative Zahl übergeben,
	 * wird der Absolutbetrag verwendet!
	 */
    public MySqrtBisekt(double r) {
    	super();
    	// Sicher stellen, dass wir in der Wurzel ein positives Argument haben
        rad = Math.abs(r);
        
        // Triviale Fälle abfangen
        if (rad <= 1.0E-6) {
        	xmid = 0.0;
        	run = true;
        }
        if (Math.abs(rad-1.0) <= 1.0E-6) {
        	xmid = 1.0;
        	run = true;
        }    
        
        // Bestimmen der Startwerte
        if (rad > 1.0) {
           a = 1.0;
           b = rad;
        } else {
           a = 0.0;
           b = 1.0;
        }
    }
    
    /**
     * @param eps1 Abbruchgenauigkeit Cauchy-Kriterium
     * @param eps2 Abbruchgenauigkeit Funktionswert
     * @param max  maximale Anzahl der Iterationen
     * @param r    der Radikand
     */
    public MySqrtBisekt(double eps1, double eps2, int max, double r) {
    	super(eps1, eps2, max, 0.0, 2.0);
    	rad = Math.abs(r); 
    	
        // Triviale Fälle abfangen
        if (rad <= 1.0E-6) {
        	xmid = 0.0;
        	run = true;
        }
        if (Math.abs(rad-1.0) <= 1.0E-6) {
        	xmid = 1.0;
        	run = true;
        }   
        
        // Bestimmen der Startwerte
        if (rad > 1.0) {
           a = 0.0;
           b = rad*rad;
        } else {
           a = 0.0;
           b = 1.0;
        }
    }    
    
    /** Implementierung der Funktion, für die die Bisektion durchgeführt werden soll */
    public double function(double x) {
    	return x*x - rad;
    }
    
    /** Der Radikant */
    private double rad;
}