package numbers.checkDigits;
import java.math.BigInteger;

/** 
 *  Berechnung der Zahlen
 *  für die Prüfziffer in der IBAN-Zahl.
 *  
 *  Da die Zahlen sehr groß werden, wird die Klasse BigInteger
 *  verwendet. Das könnte man durch einen Trick bei der Arithmetik
 *  vermeiden.
 *  
 *  @author $Author: brill $
 *  @version $Revisieion$
 */
public class IBANTest {

	public static void main(String[] args) {
		BigInteger iban = new BigInteger("542500100001234560131400");
		
		System.out.println("Die IBAN: " + iban);
		
		// 1. Wir bestimmen den Rest bei der Division von iban durch 97
		BigInteger modul = new BigInteger("97"),
				   maximum = new BigInteger("98");
		
		BigInteger rest = iban.mod(modul);
		// Das korrekte Ergebnis sollte 89 sein
		System.out.println("Der berechnete Rest: " + rest);
		
		// 2. Wir subtrahieren den Rest von 98 und erhalten die Prüfziffern
		// Ist das Ergebnis von 2. eine Zahl < 10, dann verwenden wir eine führende Null!
	    int pruefZiffer = maximum.subtract(rest).intValue();
	    // Das korrekte Ergebnis sollte 9 (also 09 als Prüfziffer)
	    System.out.println("Die Prüfziffer: " + pruefZiffer);
	    
	    // Überprüfen der Prüfziffer:
	    // Die Zahl, für die wir die letzten beiden Ziffern 00 durch die Prüfziffer
	    // ersetzen, muss Rest 1 bei der Division durch 97 haben.
	    BigInteger probe = new BigInteger("542500100001234560131481");
	    if (probe.mod(modul).intValue() == 1) 
	    	System.out.println("Die Probe wurde bestanden!");
	}

}
