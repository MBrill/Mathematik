package analysis.LogistischeGleichung;

import analysis.IterationsVerfahren1D;

/**
 *  Implementierung der Lösung der logistischen Gleichung.
 * 
 *  <P>Diese Klasse ist von Iteration1D abgeleitet. In der
 *  Oberklasse sind alle Funktionen für das Setzen
 *  der Anfangswerte, der maximalen Anzahl der Iterationen
 *  usw. zusammengefasst.</P>
 *  
 *  <P>Diese Klasse implementiert insbesondere die rein virtuelle
 *  Funktion computeIteration.</P>
 *  
 *  <P>In der Basisklasse sind zwei Variable a und b deklariert. a verwenden
 *  wir für den gleichnamigen Parameter in der Iteration. Auf b schreiben
 *  wir die Iterationsvariable.</P>
 *  
 * 
 * @author Manfred Brill
 * @version $Revision: #2 $
 */
public class LogistischeGleichung extends IterationsVerfahren1D {
	/** 
	 * Defaultwert für a ist 1.3
	 */
    private double a = 1.3;
    /**
     * Auf der Variable x steht die aktuelle Iteration und
     * zu Beginn der Startwert.
     */
    private double x = 0.2;

    /**
     * Konstruktor mit Abbruchgenauigkeit und maximaler Anzahl von Iterationen
     * 
     * @param epsilon
     *            Abbruchgenauigkeit
     * @param maxIter
     *            Maximale Anzahl der Iterationen
     */
    public LogistischeGleichung(double epsilon, int maxIter) {
        super(epsilon, maxIter);
    }	

    /**
     * Konstruktor mit a, Startwert für x, Abbruchgenauigkeit und maximaler Anzahl von Iterationen
     * 
     * @param a   
     *            Wert des Parameters a (im Intervall (0, 4)
     * @param epsilon
     *            Abbruchgenauigkeit
     * @param maxIter
     *            Maximale Anzahl der Iterationen
     */
    public LogistischeGleichung(double a, double x, double epsilon, int maxIter) {
        super(epsilon, maxIter);
        this.a = a;
        assert this.a > 0.0 && this.a < 4.0;
        
        this.x = x;
    }	
    
    
    /**
     * Durchführen der nächsten Iteration.
     * 
     * @see analysis.IterationsVerfahren1D#computeIteration()
     */
    @Override
    public void computeIteration() {
        double xalt = this.x;
        
    	this.x  = this.a * this.x * (1.0-this.x);
       
        if(Math.abs(this.x - xalt) < this.getEpsilon())
            this.stop();
    }
    
    /**
     * Abfragen des aktuellen Werts der Iteration.
     */
    public double getValue() {
    	return this.x;
    }
    
	/**
	 * Funktion für die Untersuchung des Feigenbaum-Diagramms
	 * Es wird davon ausgegangen, dass die erste Berechnung schon
	 * durchgeführt wurde.
	 * 
	 * @param k1 Wie viel Iterationen sollen zusätzlich durchgeführt werden?
	 * @return   Ergebnis der Iteration bis maxIter + k1 - 1
	 */
	public double feigenbaum(int k1) {	
		this.iter = k1;
		restart();
		compute();
		return x;	
	}    
}
