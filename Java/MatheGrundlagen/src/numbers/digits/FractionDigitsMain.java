package numbers.digits;


public class FractionDigitsMain {

	public static void main(String[] args) {
		double theNumber = 0.1;
		int basis = 2;   
		int max = 9;
			
        
        FractionDigits theDigits = new FractionDigits(theNumber, basis, max);
            
        //System.out.println("Die Konsolenausgabe der Instanz von Digits " + theDigits);
        System.out.println("Dezimalbrüche");
        System.out.println("------------------------------------------");
        System.out.println("Der Dezimalbruch, der umgewandelt wird: " + theNumber);
        System.out.println("Die verwendete Basis: " + theDigits.getBase());            
        System.out.println("Das Ergebnis");
        System.out.println("Die Zahl im Stellenwertsystem: " + theDigits);

        System.out.println("\n");
        System.out.println("Die Instanz, rekonstruiert im Dezimalsystem: "+ theDigits.numberFromDigits());
        System.out.println("Berechnungen beendet!");            

	}

}
