package numbers.factorsOptimize1;

//Imports für Log4j 2
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hauptprogramm für die Berechnung aller Teiler einer angegebenen Zahl.
 * <p>
 * Erste Optimierungsstufe, die while-Schleife wird nicht
 * bis zu number-1 durchlaufen, sondern nur bis (number-1)/2.
 * 
 * @author  $Author: brill $
 * @version $Revision: #2 $
 */
public class FactorsMain {

	/**
	 * Instanz eines Loggers
	 */
	static final Logger log = LogManager.getLogger();
	
	/**
	 * Hauptprogramm für den zwei Optimize1.
	 * 
	 * Instanziieren der Berechnungsklasse und ausgeben
	 * der Ergebnisse auf der Konsole.
	 */
	public static void main(String[] args) {
		
		log.trace(">> main in Branch Optimize1");		
		Long number = (long)1425;

		ComputeFactors factors = new ComputeFactors(number);
		factors.compute();
		
		System.out.println(factors);	
		log.trace("<< main in Branch Optimize1");	
	}
}
