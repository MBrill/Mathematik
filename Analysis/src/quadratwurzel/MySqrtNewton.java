/**
 * Numerische Berechnung der Quadratwurzel einer reellen Zahl r 
 * auf der Basis des Newton-Verfahrens.
 * 
 * Wir lösen die Gleichung
 * x^2 - r = 0.
 * 
 * @author Manfred Brill
 * @version $Revision: #1 $
 * $Date: 2013/07/11 $
 */
public class MySqrtNewton extends Newton {
	
	/**
	 * Default-Werte der Regula Falsi
	 * Radikant 0.0
	 */
    public MySqrtNewton() {
    	super();
        rad = 0.0;
    }
    
	/**
	 * Default-Werte der Regula Falsi
	 * @param r der Radikand, für den die Wurzel bestimmt werden soll
	 * 
	 * r muss positiv sein. Wird eine negative Zahl übergeben,
	 * wird der Absolutbetrag verwendet!
	 */
    public MySqrtNewton(double r) {
    	super();
    	// Sicher stellen, dass wir in der Wurzel ein positives Argument haben
        rad = Math.abs(r);
        
        // Triviale Fälle abfangen
        if (Math.abs(rad) <= 1.0E-6) {
        	xn = 0.0;
        	run = true;
        }
        if (Math.abs(rad-1.0) <= 1.0E-6) {
        	xn = 1.0;
        	run = true;
        }    
        
        // Bestimmen der Startwerte
        if (rad > 1.0) {
           xn = rad*rad;
        } else {
           xn = 0.5;
        }
    }
    
    /**
     * @param eps1 Abbruchgenauigkeit Cauchy-Kriterium
     * @param eps2 Abbruchgenauigkeit Funktionswert
     * @param max  maximale Anzahl der Iterationen
     * @param r    der Radikand
     */
    public MySqrtNewton(double eps1, double eps2, int max, double r) {
    	super(eps1, eps2, max, 0.0);
    	rad = Math.abs(r); 
    	
        // Triviale Fälle abfangen
        if (rad <= 1.0E-6) {
        	xn = 0.0;
        	run = true;
        }
        if (Math.abs(rad-1.0) <= 1.0E-6) {
        	xn = 1.0;
        	run = true;
        }   
        
        // Bestimmen der Startwerte
        if (rad > 1.0) {
           xn = rad;
        } else {
           xn = 0.5;
        }  	
    }    
    
    /** Implementierung der Funktion, für die das Newton-Verfahren durchgeführt werden soll */
    @Override
    public double function(double x) {
    	return x*x - rad;
    }
 
    /** Implementierung der Ableitung der Funktion, für die das Newton-Verfahren durchgeführt werden soll */
    @Override
    public double derivative(double x) {
    	return 2.0*x;
    }
    
    /** Der Radikant */
    private double rad;
}
