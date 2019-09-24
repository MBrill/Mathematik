package numbers.assignment;

import java.util.ArrayList;


/**
 * Berechnung aller Teiler einer ganzen Zahl. 
 *
 * Aufgabenstellung
 */
public class ComputeFactors {

	private Long number;
	private ArrayList<Long> factors;
	
	public ComputeFactors() {
		this.number = (long)2;
		this.factors = new  ArrayList<Long>();
	}

	public ComputeFactors(Long number) {
		this.number = number;
		this.factors = new  ArrayList<Long>();
	}
	
	public ComputeFactors(long number) {
		this.number = number;
		this.factors = new  ArrayList<Long>();
	}
	
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
	
	@Override
        public String toString() {
	    String text="";
	    text = "Die Teiler der Zahl " + this.number + ":\n";
	    text += this.factors.toString();
	    return text;
	}
}
