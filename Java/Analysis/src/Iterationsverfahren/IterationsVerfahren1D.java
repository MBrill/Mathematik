package Iterationsverfahren;

/**
 * Rein virtuelle Basisklasse für eindimensionale Iterationsverfahren, die in der Lehrveranstaltung Analysis betrachtet werden.
 * 
 * <P>
 * Die Klasse geht von zwei Startwerten aus, wie sie bei AGM oder der Bisektion verwendet werden. Werden mehr Startwerte benötigt
 * muss dies in der abgeleiteten Klasse vereinbart werden.
 * </P>
 * 
 * <P>
 * Allen Iterationsverfahren ist gemeinsame, dass sie eine double-Zahl epsilon für das Abbruchkriterium benötigen. Auch eine
 * maximale Anzahl von Iterationen als "Notbremse" wird immer verwendet.
 * </P>
 * 
 * <P>
 * Die eigentliche Durchführung der Berechnung einer Iteration wird in der Funktion computeIteration() durchgeführt. Diese
 * Funktion muss die abgeleiteten und instanziierbaren Klassen implementieren. Die Basisklasse bietet die Methode
 * {@link #stop()}. Ist das Abbruchkriterium durch epsilon erreicht muss diese aufgerufen werden. Die Berechnung erfolgt auf
 * keinen Fall im Konstruktor, sondern nur nach expliziter Anforderung durch Aufruf der Funktion compute().
 * </P>
 */
public abstract class IterationsVerfahren1D {

    /** Maximal durchzuführende Iterationen */
    protected int maxIter = 0;
    /** Zähler für die durchgeführten Iterationen */
    protected int iter = 0;
    /** Abbruchgenauigkeit für die Iterationen */
    private double epsilon = 0.0;
    /** boolean für das frühzeitige anhalten druch Stopkriterium */
    private boolean shouldStop = false;
    /** Gibt an ob das Verfahren zu Ende ist. 
     * 
     * Zeigt nicht wie das Verfahren angehalten wurde 
     */
    private boolean finished = false;

    /** Defaultkonstruktor **/
    public IterationsVerfahren1D() {}
    /**
     * Konstruktor mit allen Parametern
     * 
     * @param epsilon
     *            Abbruchgenauigkeit
     * @param maxIter
     *            Maximal durchzuf�hrende Iterationen
     */
    public IterationsVerfahren1D(double epsilon, int maxIter) {
        this.epsilon = epsilon;
        this.maxIter = maxIter;
    }

    /**
     * Führe die Berechnung durch
     */
    public void compute() {
        if(this.shouldStop) {
            System.err.println("Das Verfahren ist schon beendet!");
            return;
        }

        do {
            computeIteration();
            ++this.iter;
        } while(!this.shouldStop && this.iter < this.maxIter);

        this.finished = true;
    }

    /**
     * Berechne eine Iteration.
     */
    public abstract void computeIteration();

    /**
     * Signalisiere dass das Verfahren gestoppt werden sollte bevor die maximale Iteration erreicht ist. 
     * Soll aufgerufen werden
     * wenn das Abbruchkriteriuem mit epsilon erreicht wurde.
     */
    public final void stop() {
        this.shouldStop = true;
    }

    /**
     * Setze die Variable shouldStop auf false. Damit kann mit der aktuellen Anzahl der Iterationen
     * neu gerechnet werden.
     * 
     * Wird beispielsweise in der Funktion LogistischeGleichung.feigenbaum verwendet!
     */
    public final void restart() {
        this.shouldStop = false;
    }
    
    /**
     * Wurde das Verfahren abgebrochen?
     * 
     * @return true falls gestoppt wurde
     */
    public final boolean wasStopped() {
        return this.shouldStop;
    }

    /**
     * Ist das Verfahen beendet? Entweder durch Stopkriterium oder durch Erreichen der maximalen Iterationsanzahl.
     * 
     * @return true falls Verfahren beendet
     */
    public final boolean isFinished() {
        return this.finished;
    }

    /**
     * Gibt die maximale Anzahl von Iterationen zurück.
     * 
     * @return die Maximale Anzahl von Iterationen
     */
    public final int getMaxNumberOfIterations() {
        return this.maxIter;
    }

    /**
     * Gibt die Anzahl der Iterationen zurück
     * 
     * @return Die Anzahl der Iterationen
     */
    public final int getNumberOfIterations() {
        return iter;
    }

    /**
     * Gibt epsilon zurück.
     * 
     * @return epsilon
     */
    public final double getEpsilon() {
        return epsilon;
    }

    /**
     * Setzt die stop Variablen und die Anzahl der Iterationen zur�ck um die Berechnung wieder durchf�hren zu k�nnen. Danach
     kann wieder {@link IterationsVerfahren1D#compute() compute} aufgerufen werden.
     */
    public void reset() {
        this.shouldStop = false;
        this.finished = false;
        this.iter = 0;
    }
}
