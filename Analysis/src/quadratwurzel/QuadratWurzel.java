package analysis.quadratwurzel;

/** 
 * Implementierung der Berechnung einer Quadratwurzel
 *
 *  Die Folge benötigt einen Startwert.
 *  Wir verwenden die Variable a, als Startwert der Iteration.
 *  </p>
 *
 * @author Patrick Schwartz
 * @version $Revision: #5 $
 */
import analysis.IterationsVerfahren1D;

/**
 * @author schwartz
 * 
 */
public class QuadratWurzel extends IterationsVerfahren1D {

    /** Startwert des Verfahrens */
    private double a = 0.0;
    /** Zahl aus der wir die Wurzel ziehen wollen */
    private double radikand = 0.0;

    /**
     * Konstruktor mit allen Parametern
     * 
     * @param a
     *            Startwert
     * @param epsilon
     *            Abbruchgenauigkeit für die Iterationen
     * @param maxIter
     *            Maximal durchzuführende Iterationen
     */
    public QuadratWurzel(double a, double epsilon, int maxIter) {
        super(epsilon, maxIter);
        this.a = a;
    }

    /*
     * (non-Javadoc)
     * 
     * @see analysis.IterationsVerfahren1D#computeIteration()
     */
    @Override
    public void computeIteration() {
        double altA = this.a;
        this.a = 0.5 * (a + radikand / a);

        if(Math.abs(this.a - altA) <= this.getEpsilon())
            this.stop();
    }

    /**
     * Setzen der Zahl, aus der wir die Wurzel ziehen möchten. Nach dem Aufruf dieser Funktion muss die Berechnung neu aufgerufen
     * werden!
     * 
     * Falls eine negative Zahl übergeben wird, wird -rad verwendet!
     * 
     * @param rad
     *            Die Zahl
     */
    public final void setRadikand(double rad) {

        this.radikand = rad >= 0.0 ? rad : -rad;

        this.reset();
    }

    /**
     * Gibt den Wert von a zurueck
     * 
     * @return a
     */
    public final double getA() {
        return this.a;
    }

    /**
     * Gibt den Radikand zurueck
     * 
     * @return Der Radikand
     */
    public final double getRadikand() {
        return this.radikand;
    }

}
