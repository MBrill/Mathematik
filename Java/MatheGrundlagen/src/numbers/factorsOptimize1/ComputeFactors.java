package numbers.factorsOptimize1;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Berechnung aller Teiler einer ganzen Zahl. 
 * 
 * Diese Klasse realisiert die Aufgabenstellung, denn die
 * Berechnung ben√∂tigt viel zu viele Berechnungen und wird
 * anschlie√üend optimiert.
 * 
 * Die Zahl selbst und der komplement√§re Teiler 1 werden nicht
 * in die Liste aufgenommen!
 * 
 * Die Optimierung besteht darin, dass wir die while-Schleife schon bei
 * this.number div 2 aufhˆren kˆnnen; grˆﬂere Teiler kann es nicht geben!
 * Dadurch halbieren wir die Anzahl der Schleifendurchl‰ufe!
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
	 * Zahl, f√ºr die die Teiler berechnet werden sollen.
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
	 * @param number Zahl, f√ºr die die Teiler berechnet werden sollen
	 */
	public ComputeFactors(Long number) {
		this.number = number;
		this.factors = new  ArrayList<Long>();
	}
	
	/**
	 * Instanz mit einer angegebenen Zahl.
	 * 
	 * @param number Zahl, f√ºr die die Teiler berechnet werden sollen
	 */
	public ComputeFactors(long number) {
		this.number = number;
		this.factors = new  ArrayList<Long>();
	}
	
	/**
	 * Alle Teiler berechnen, wie in K√∂ster, Pagel, Six
	 * auf Seite 230 beschrieben. 
	 * <P>
	 * Wir berechnen die maximale Zahl, bis zu der wir 
	 * die while-Schleife durchlaufen, als maxWhile = this.number div 2
	 */
	public void compute() {
		log.trace(">> compute im Zweig Optimize1");
		int counter = 0;
		Long maxWhile = this.number/(long)2;
		log.info("Obergrenze f√ºr die while-Schleife ist {}", maxWhile);
		
		Long helpDiv = (long)2;
		log.debug("Die Zahl, f√ºr die der Teiler berechnet wird ist {}", this.number);
		
		while (helpDiv <= maxWhile) {
			log.debug("Der Wert der Hilfsvariable helpDiv ist {}", helpDiv);
			if (this.number % helpDiv == 0) {
				// Die Zahl helpDiv ist ein Teiler
				log.debug("-- compute: Neuer Teiler {} gefunden!", helpDiv);
				this.factors.add(helpDiv);
			}
			helpDiv++;
			counter++;
		}
		
		if (log.isInfoEnabled()) {
			log.info("-- compute: Die Schleife wurde {}-mal durchlaufen.", counter);
		    if (!this.factors.isEmpty()) {
			   log.info("-- compute: Der letzte gefundene Teiler ist {}.", this.factors.get(this.factors.size()-1) );
		    }	
		    else {
			   log.info("-- compute: Die eingegebene Zahl ist eine Primzahl!");
		    }
		}
		log.trace("<< compute im Zweig Optimize1");
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
