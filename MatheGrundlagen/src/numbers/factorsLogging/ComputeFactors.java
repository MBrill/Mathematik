package numbers.factorsLogging;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Berechnung aller Teiler einer ganzen Zahl. 
 * 
 * Diese Klasse realisiert die Aufgabenstellung, denn die
 * Berechnung benötigt viel zu viele Berechnungen und wird
 * anschließend optimiert.
 * 
 * Die Zahl selbst und der komplementäre Teiler 1 werden nicht
 * in die Liste aufgenommen!
 * 
 * @author  $Author: brill $
 * @version $Revision: #4 $
 */
public class ComputeFactors {

	/**
	 * Instanz eines log4j2 Loggers.
	 * 
	 * Der Name ist numbers.factorsLogging.ComputeFactors. Die Konfiguration
	 * liegt in der XML-Datei log4j2.xml. Der Logger dieser Klasse
	 * hat als Default den Level INFO.
	 */
	static final Logger log = LogManager.getLogger();
	/**
	 * Zahl, für die die Teiler berechnet werden sollen.
	 */
	private Long number;
	/**
	 * Liste der berechneten Teiler
	 */
	private ArrayList<Long> factors;
	
	/**
	 * Instanz mit dem Default 2.
	 */
	public ComputeFactors() {
		this.number = (long)2;
		this.factors = new  ArrayList<Long>();
	}

	/**
	 * Instanz mit einer angegebenen Zahl.
	 * 
	 * @param number Zahl, für die die Teiler berechnet werden sollen
	 */
	public ComputeFactors(Long number) {
		this.number = number;
		this.factors = new  ArrayList<Long>();
	}
	
	/**
	 * Instanz mit einer angegebenen Zahl.
	 * 
	 * @param number Zahl, für die die Teiler berechnet werden sollen
	 */
	public ComputeFactors(long number) {
		this.number = number;
		this.factors = new  ArrayList<Long>();
	}
	
	/**
	 * Alle Teiler berechnen, wie in Köster, Pagel, Six
	 * auf Seite 230 beschrieben.
	 */
	public void compute() {
		log.trace(">> compute");
		int counter = 0;
		Long helpDiv = (long)2;
		log.debug("Die Zahl, für die der Teiler berechnet wird ist {}", this.number);
		
		while (helpDiv <= this.number-1) {
			log.debug("Der Wert der Hilfsvariable helpDiv ist {}", helpDiv);
			if (this.number % helpDiv == 0) {
				// Die Zahl helpDiv ist ein Teiler
				log.debug("-- compute: Neuer Teiler {} gefunden!", helpDiv);
				this.factors.add(helpDiv);
			}
			helpDiv++;
			counter++;
		}
		log.info("-- compute: Die Schleife wurde {}-mal durchlaufen.", counter);
		if (log.isInfoEnabled()) {
		    if (!this.factors.isEmpty()) {
			   log.info("-- compute: Der letzte gefundene Teiler ist {}.", this.factors.get(this.factors.size()-1) );
			   log.info("-- compute: Es wurden {} Schleifendurchläufe zu viel durchgeführt!", counter - this.factors.get(this.factors.size()-1));
		    }	
		    else {
			   log.info("-- compute: Die eingegebene Zahl ist eine Primzahl!");
		    }
		}
		log.trace("<< compute");
	}
	
	/**
	 * Ausgabe der Teiler.
	 */	
	@Override
    public String toString() {
	    String text="";
	    if (!this.factors.isEmpty()) {
	    	text = "Die Teiler der Zahl " + this.number + ":\n";
	    	text += this.factors.toString();
	    }	
	    else {
	    	text = "Die Zahl " + this.number + " ist eine Primzahl!";
	    }
	    return text;
    }	
}
