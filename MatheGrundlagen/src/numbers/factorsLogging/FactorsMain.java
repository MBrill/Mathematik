package numbers.factorsLogging;

// Imports für Log4j 2
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hauptprogramm für die Berechnung aller Teiler einer angegebenen Zahl.
 * <p>
 * Diese Version enthält noch keine Optimierungen, sondern enthält
 * als erste Version Ausgaben mit Hilfe von Log4J2.
 * 
 * @author  $Author: brill $
 * @version $Revision: #3 $
 */
public class FactorsMain {

	/**
	 * Instanz eines Loggers
	 */	
	static final Logger log = LogManager.getLogger();
	
	/**
	 * Hauptprogramm für den zwei Logging.
	 * 
	 * Instanziieren der Berechnungsklasse und ausgeben
	 * der Ergebnisse auf der Konsole.
	 */
	public static void main(String[] args) {
		
		log.trace(">> main in Branch Logging");
		Long number = (long)1425;
		ComputeFactors factors = new ComputeFactors(number);
		factors.compute();
		
		System.out.println(factors);
		log.trace("<< main in Branch Logging");
	}
}
