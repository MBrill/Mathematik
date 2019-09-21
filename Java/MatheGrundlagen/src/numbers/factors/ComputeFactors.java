package numbers.factors;

import java.util.ArrayList;

/**
 * Berechnung aller Teiler einer ganzen Zahl. 
 * 
 * Die Zahl selbst und der komplementäre Teiler 1 werden nicht
 * in die Liste aufgenommen!
 * 
 * @author  $Author: brill $
 * @version $Revision: #6 $
 */
public class ComputeFactors {

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
	 * Alle Teiler berechnen
	 */
	public void compute() {
		Long helpDiv = (long)2;
		
		while (helpDiv <= this.number-1) {
			if (this.number % helpDiv == 0) {
				// Die Zahl helpDiv ist ein Teiler
				this.factors.add(helpDiv);
			}
			helpDiv++;
		}
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
