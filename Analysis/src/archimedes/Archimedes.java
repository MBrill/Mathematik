package analysis.archimedes;

import analysis.IterationsVerfahren1D;

/**
 * Näherung der irrationalen  Zahl pi mit Hilfe des Verfahrens von Archimedes.
 * 
 * @author Patrick Schwartz
 * @version $Revision: #3 $
 */
public class Archimedes extends IterationsVerfahren1D {

	/** 
	 * Defaultwert für a ist 3.0
	 */
    private double a = 3.0;
    /**
     * Defaultwert für b ist 2.0 Wurzel (3).
     */
    private double b = 2.0 * Math.sqrt(3.0);

    /**
     * Konstruktor mit allen Parametern.
     * 
     * @param epsilon
     *            Abbruchgenauigkeit
     * @param maxIter
     *            Maximale Anzahl der Iterationen
     */
    public Archimedes(double epsilon, int maxIter) {
        super(epsilon, maxIter);
    }

    /**
     * Durchführen der nächsten Iteration - bei Archimedes verdoppeln wir die
     * Anzahl der Ecken und berechnen damit eine neue Näherung von pi.
     * 
     * @see analysis.IterationsVerfahren1D#computeIteration()
     */
    @Override
    public void computeIteration() {
        this.b = 2.0 / ((1.0 / this.b) + (1.0 / this.a));
        this.a = Math.sqrt(a * this.b);

        assert this.a < Math.PI && Math.PI < this.b;
        
        if(Math.abs(this.a - this.b) < this.getEpsilon())
            this.stop();
    }

    /**
     * Gibt die aktuell berechnete Naeherunng von pi zurueck. Kann anstelle von {@link IterationsVerfahren1D#compute() compute}
     * aufgerufen werden.
     * 
     * @return Die aktuell berechnete Naeherunng von PI.
     */
    public double getPi() {
        if(!this.isFinished())
            this.compute();

        return (this.a + this.b) / 2.0;
    }
}
