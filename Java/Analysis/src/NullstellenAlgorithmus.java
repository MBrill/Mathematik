/**
 * <P>Rein virtuelle Basisklasse für eindimensionale Iterationsverfahren zur Bestimmung von
 * Nullstellen von stetigen oder differenziberbaren Funktionen, die in der
 * Lehrveranstaltung Analysis betrachtet werden. Diese Basisklasse ist von
 * IterationsVerfahren1D abgeleitet, so dass die dort vereinbarten Variablen für
 * die Anzahl der maximalen Iterationen und die entsprechenden set- und
 * get-Funktionen verwendet werden können.</P>
 * 
 * <P> Die konkreten Verfahren implementieren die abstrakte Funktion
 * computeIteration(). Die Funktion, für die die Nullstelle bestimmt wird, wird durch
 * Überschreiben der abstrakten Funktion function implementiert. 
 * Alle Nullstellenverfahren verwenden eine weitere Variable epsilon2 für
 * die Abbruchkritieren.</P>
 * 
 * @author Manfred Brill
 * @version $Revision: #3 $
 */
package analysis;

import analysis.Function;

public abstract class NullstellenAlgorithmus extends IterationsVerfahren1D {
	
    /** 
     *  Abbruchgenauigkeit für die Überprüfung auf den Funktionswert
     *  Wir suchen Nullstellen, also überprüfen wir, ob |f(x)| < epsilon2
     *  erfüllt ist.
     */
    protected double epsilon2 = 0.0; 	

	/**
	 * Die Funktion, für die wir das Verfahren durchführen, als Interface.
	 */
	protected Function function;
	
    /**
     * Konstruktor mit allen Parametern
     * 
     * @param eps
     *            Abbruchgenauigkeit für den Vergleich der letzten beiden Näherungen
     * @param eps2
     *            Abbruchgenauigkeit für den Vergleich des letzten Funktionswerts auf "=0"
     * @param maxIter
     *            Maximal durchzuführende Iterationen
     */
    public NullstellenAlgorithmus(double eps, double eps2, int maxIter, Function f) {
    	super(eps, maxIter);
    	this.epsilon2 = eps2;
    	this.function = f;
    }
    
    /** Abstrakte Funktion - hier müssen die abgeleiteten Klassen das Verfahren implementieren.</P> */
    public abstract void computeIteration();	  
    
	/**
	 * @param eps Gewünschte Abbruchgenauigkeit für die Überprüfung des Funktionswerts
	 */
	public void setEpsilon2(double eps) {
		epsilon2 = eps;
	}


	/** 
	 * @return Abbruchgenauigkeit für die Überprüfung des Funktionswerts
	 */
	public double getEpsilon2() {
		return epsilon2;
	}
	

}
