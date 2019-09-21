package numbers.factorsOptimize2;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Berechnung aller Teiler einer ganzen Zahl. 
 * <p>
 * Diese Klasse realisiert die Aufgabenstellung, denn die
 * Berechnung benötigt viel zu viele Berechnungen und wird
 * anschließend optimiert.
 * <p>
 * Die Zahl selbst und der komplementäre Teiler 1 werden nicht
 * in die Liste aufgenommen!
 * Die while-Schleife wird bereits nur bis this.number div 2
 * durchlaufen.
 * <p>
 * Als zweite Optimierung wird ausgenutzt, dass, falls wir einen Teiler
 * gefunden haben, auch der komplementäre Teiler gefunden ist. Diesen
 * komplementären Teiler können wir durch this.number/teiler berechnen.
 * Diesen Teiler schreiben wir in eine lokale Liste. Beide Listen sind am 
 * Ende der Funktion compute() gleich groß und werden in einem letzten
 * Schritt vereinigt, um die richtige Reihenfolge im Ergebnis zu gewährleisten.
 * Dazu könnte Collections.sort verwendet werden, aber da wir die Reihenfolge
 * kennen wird dies explizit realisiert.
 * <p>
 * Diese Änderung führt zu einer weiteren Reduktion der Schleifendurchläufe,
 * denn wir müssen nur alle Zahlen zwischen 2 und der Wurzel der
 * betrachteten Zahl betrachten. 
 * <p>
 * Beweis:
 * Alle Teiler x, die größer als diese Wurzel sind,
 * haben dann ein Quadrat, das größer als this.number ist. Da der komplementäre
 * Teiler y zu x die Ungleichung x <= y erfüllt, muss dann auch x*y > this.number
 * sein.
 * 
 * @author  $Author: brill $
 * @version $Revision:
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
	 * <P>
	 * Wir berechnen die maximale Zahl, bis zu der wir 
	 * die while-Schleife durchlaufen, als 
	 * maxWhile = floor(wurzel(this.number)).
	 */
	public void compute() {
		log.trace(">> compute im Zweig Optimize2");
		// Zähler für die Schleifendurchläufe
		int counter = 0;
		/* Lokale Liste, in der die komplementären
		 * Teiler gespeichert werden.
		 */
		ArrayList<Long> complement = new ArrayList<Long>();
		
		/*
		 * Wir gehen nur noch bis wurzel(this.number). 
		 * Die Begründung findet man im Kommentar zur Klasse!
		 * 
		 * Der Cast ist notwendig, da Math.floor() als Ergebnis
		 * float oder double hat!
		 */
		Long maxWhile = (long)Math.floor(Math.sqrt(this.number));
		log.info("Obergrenze für die while-Schleife ist {}", maxWhile);
		
		Long helpDiv = (long)2, compDiv;
		
		log.debug("Die Zahl, für die der Teiler berechnet wird ist {}", this.number);		
		while (helpDiv <= maxWhile) {
			log.debug("Der Wert der Hilfsvariable helpDiv ist {}", helpDiv);
			if (this.number % helpDiv == 0) {
				// Die Zahl helpDiv ist ein Teiler
				log.debug("-- compute: Neuer Teiler {} gefunden!", helpDiv);
				this.factors.add(helpDiv);
				/* Jetzt berechnen wir den komplementären Teiler und
				 * fügen ihn unserer lokalen Liste hinzu
				 */
				compDiv = this.number/helpDiv;
				/*
				 * Der komplementäre Teiler wird immer am Anfang der Hilfsliste
				 * hinzugefügt. Das macht es später einfacher, beide
				 * Listen zu vereinigen!
				 */
				complement.add(0, compDiv);
			}
			helpDiv++;
			counter++;
		}
		
		log.info("-- compute: Die Schleife wurde {}-mal durchlaufen.", counter);
	    if (!this.factors.isEmpty()) {
		   log.info("-- compute: Der letzte gefundene Teiler ist {}.", this.factors.get(this.factors.size()-1));
		   log.info("-- compute: Der letzte gefundene komplementäre Teiler ist {}.", complement.get(0));
	    }	
	    else {
		   log.info("-- compute: Die eingegebene Zahl ist eine Primzahl!");
	    }
		/*
		 * Im letzten Schritt vereinigen wir beide Listen. Dabei wird die
		 * Liste complement an die Liste factors angehängt!
		 */
		factors.addAll(complement);	    
		log.trace("<< compute im Zweig Optimize2");
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
