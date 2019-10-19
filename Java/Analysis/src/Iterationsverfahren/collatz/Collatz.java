package Iterationsverfahren.collatz;

import Iterationsverfahren.IterationsVerfahren1D;

/** Implementierung der Collatz-Folge
 *
 *  <P>Diese Klasse ist von Iteration1D abgeleitet</P>
 *  
 *  <P>Die Folge benötigt nur einen der beiden Startwerte der Basisklasse;
 *  wir verwenden die Variable a, als Startwert der Iteration.
 *  </P>
 */
public class Collatz extends IterationsVerfahren1D {
	/**
     * Default-Konstruktor.
     *
     * Startwerte                       a=0
     * Maximale Anzahl der Iterationen: 100
     * 
     * Der Startwert wird auf folge[0] abgelegt.
     */
    public Collatz() {
    	 super(0.5, 100);
    	 folge = new double[maxIter];
    	 folge[0] = 0.0;
	}	

	/** Konstruktor mit der gewünschten maximalen Anzahl der Iterationen
     *
     * Startwerte                       a=0
     * Maximale Anzahl der Iterationen: n
     *      
     * Der Startwert wird auf folge[0] abgelegt.
     */
	public Collatz(int n) {
		super(0.5, n);
   	    folge = new double[maxIter];
   	    folge[0] = 0.0;
	}	


	/** Konstruktor mit Angabe eines Startwerts a
    *
    * Maximale Anzahl der Iterationen: 100
    */
	public Collatz(double aa) {
		super(0.5, 100);
   	    folge = new double[maxIter];
   	    folge[0] = aa;
	}
	
	@Override
    public void computeIteration() {
		double a = folge[iter];
		if ((a % 2.0) == 1.0) {
			folge[iter+1] = 3.0*a + 1;
        }
        else {
        	folge[iter+1] = a/2.0;
        }
		
        if(Math.abs(a - folge[iter+1]) < this.getEpsilon())
            this.stop();
    	iter++;
	}
	
    /** Funktion, die das i-te berechnete Folgeglied zurückgibt */
	public int getNumber(int i) {
		return (int) folge[i];
	}
	
    /** Feld für die berechnete Glieder der Folge **/
    private double folge[];	
}
