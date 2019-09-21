package Collatz;

//Imports für Log4j 2
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Java-Klasse für die Realisierung der Collatz-Funktion
 */
public class Collatz {

	/**
	 * Instanz eines Loggers aus Log4j 2.
	 * 
	 * Wir verwenden den Defaultname, "Collatz.Collatz",
	 * den wir auch mit Hilfe des Klassennamens erhalten würden.
	 */
	static final Logger log = LogManager.getLogger();
	
    /** 
     * Startwert. 
     */
    private int a=1;    
    /**
     *  Zähler für die durchgeführten Iterationen
     */
    private int iter=0;  
    
    /**
     * Konstruktor mit gewünschtem Startwert.
     * 
     * @param aa  Startwert für die Collatz-Folge
     */
    public Collatz(int aa) {
    	log.info(">> ** Im Konstruktor mit Startwert {}", aa);
	    iter = 0;
	    a = aa;
    }

    /** 
     * Implementierung der Collatz-Folge.
     * 
     * Die Folge wird berechnet, bis der Wert 1 erreicht wird.
     * 
     * @return Anzahl der Iterationen, bis die 1 erreicht wird.
     */ 
    public int compute() {
    	do {
		   if (a%2 == 0) 
			a = a/2;
		   else
			a = 3*a+1;
			
    	   iter++;
    	   log.info("Die {}-te Iteration hat den Wert {}", iter, a);
    	}  while (a != 1);
	    return iter;
    }
    
    /** 
     * Implementierung der Collatz-Folge.
     * 
     * Die Folge wird berechnet, bis der Wert 1 erreicht wird. Dabei wird 
     * jeder Wert der Folge auf der Konsole ausgegeben.
     * <p>
     * Die letzte Zahl der Folge, die 1, wird nach der while-Schleife
     * ausgegeben (und nicht berechnet!).
     */ 
    public void computeAndPrint() {
    	do {
		   System.out.println("Die " + iter + "-te Iteration: " + a);
		   log.info("Die {}-te Iteration hat den Wert {}", iter, a);
		   if (a%2 == 0) 
			   a = a/2;
		   else
			   a = 3*a+1;

    		this.iter++;
    	}  while (a != 1);
    	// Die letzte Ausgabe ist festgelegt:
	    System.out.println("Die " + iter + "-te und letzte Iteration: 1");
	    log.info("Die {}-te und letzte Iteration hat den Wert {}", iter, a);
    }

    /** Abfragen der durchgeführten Iterationen */
    public int getIter() {
    	return this.iter;
    }
    
    /**  
     * Setzen der Startwerte
     * 
     * @param aa der neue Startwert, der verwendet werden soll
     */
    public void setStartValue(int aa) {
    	a = aa;
    }
    
    /**
     * Abfragen des eingestellten Startwerts.
     * 
     * Die Ausgabe ist abhängig davon, ob die Folge bereits berechnet wurde.
     * 
     * @return Rückgabewert ist entweder der Startwert für a oder
     *         das berechnete Folgeglied nach der Iteration.
     */
    public int getValueA() {
    	return a;
    }
}
