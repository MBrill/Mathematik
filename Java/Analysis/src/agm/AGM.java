package analysis.agm;

import analysis.IterationsVerfahren1D;

/**
 * Implementierung der Berechnung des arithmetisch-geometrischen Mittels AGM(a, b) für
 * zwei Startwerte a und b.
 * 
 * Abgeleitet von der abstrakten Basisklasse IterationsVerfahren1D.
 * 
 * @author patrick Schwartz
 * @version $Revision: #3 $
 */
public final class AGM extends IterationsVerfahren1D {
    
    /** 
     * Startwert a 
     *
     * Defaultwert: 0.0
     */
    private double a = 0.0;
    /** 
     * Startwert b
     * 
     *  Defaultwert: 0.0
     */
    private double b = 0.0;
    
    /**
     * Konstruktor
     * 
     * @param epsilon Abbruchgenauigkeit
     * @param maxIter Maximale Anzahl der Iterationen
     * @param a Startwert a
     * @param b Startwert b
     */
    public AGM(double epsilon, int maxIter, double a, double b) {
        super(epsilon, maxIter);
        this.a = a;
        this.b = b;
    }
    
    /**
     * a enthält nach der nächsten Iteration das arithmetische Mittel (a+b)/2,
     * b das geometrische Mittel sqrt(a*b).
     * 
     * Abbruch: falls der Abstand zwischen a und b nach Durchführen der Iteration
     * kleiner als das vorgegebene Epsilon ist.
     */
    @Override
    public void computeIteration() {
        double an = a;
        double bn = b;

        this.a = (an + bn) / 2.0;
        this.b = Math.sqrt(an * bn);

        if(Math.abs(this.a - this.b) <= this.getEpsilon())
            this.stop();
    }
    
    /**
     * Zurücksetzen der Berechnung mit neuen Startwerten. Nach dieser Methode kann wieder {@link IterationsVerfahren1D#compute() compute} aufgerufen werden.
     * 
     * @param newA Neuer Wert fuer a
     * @param newB Neuer Wert fuer b
     */
    public void resetWithNewValues(double newA, double newB) {
        this.a = newA;
        this.b = newB;

        this.reset();
    }
    
    /** Abfrage von a */
    public double getA() {
        return this.a;
    }
    /** Abfrage von b */
    public double getB() {
        return this.b;
    }
}
