package numbers.factorsOut;

/**
 * Hauptprogramm für die Berechnung aller Teiler einer angegebenen Zahl.
 */
public class FactorsMain {

	public static void main(String[] args) {
		
		Long number = (long)12;
		ComputeFactors factors = new ComputeFactors(number);
		factors.compute();
		
		System.out.println(factors);
	}
}
