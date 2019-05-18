/** Implementierung der Collatz-Folge
 *
 *  <P>Diese Klasse ist von Iteration1D abgeleitet</P>
 *  
 *  <P>Die Folge benötigt nur einen der beiden Startwerte der Basisklasse;
 *  wir verwenden die Variable a, als Startwert der Iteration.
 *
 * @author Manfred Brill
 * @version 1.0
 */
public class Collatz extends Iteration1D {

	   /**
     * Default-Konstruktor.
     *
     * Startwerte                       a=0
     * Maximale Anzahl der Iterationen: 100
     */
    public Collatz() {
    	 super(0.5, 100, 0.0, 0.0);
    	 folge = new double[maxIter];
    	 folge[0] = 0.0;
	}	

	/** Konstruktor mit der gewünschten maximalen Anzahl der Iterationen
     *
     * Startwerte                       a=0
     * Maximale Anzahl der Iterationen: n
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
		super(aa, 0.0);
		setMaximumNumberOfIterations(100);
		setEpsilon(0.5);
   	    folge = new double[maxIter];
   	    folge[0] = aa;
	}
	
	@Override
	public void compute() {		
    	// Abfragen, ob die Berechnung bereits durchgeführt wurde
    	if (!run) {
      	  while( !stop(a, 1.0) ) {
    		   // Vorheriger Wert merken für das Abbruchkriterium
               if ((a % 2.0) == 1.0) {
            	   a = 3.0*a + 1;
               }
               else {
            	   a = a/2.0;
               }
               folge[iter+1] = a;
    		   iter++;
    	  };
    	}
    	run = true;		
	}
	
    /**
	 * Funktion, die das i-te berechnete Folgeglied zurückgibt
	 */
	public int getNumber(int i) {
		return (int) folge[i];
	}
    /** 
     * <P>Feld für die berechnete Glieder der Folge
     */
    private double folge[];	
}
