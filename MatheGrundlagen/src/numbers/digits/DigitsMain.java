package numbers.digits;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;



//JSON Parser
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Hauptprogramm fÃ¼r die Verwendung von Stellenwertsystemen in der Klasse @see Digits.
 * <P>
 * Die Anwendung liest eine Dezimalzahl, die gewünschte Basis und die maximale Anzahl der
 * verwendeten Ziffern ein. In der Instanz der Klasse Digits werden die Ziffern
 * berechnet.
 * 
 * @author $Author: brill $
 * @version $Revision: #2 $
 */
public class DigitsMain {
	
	public static void main(String[] args) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		File inFile = new File("Digits.json"),
			 outFile = new File("Digits.out");			

		try (PrintWriter out = new PrintWriter(outFile);) {
			
			// JSON Datei mit den Eingaben parsen
			JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(inFile));
			
			long theNumber = 123;
			int basis = 10;       
			
            theNumber = (Long) jsonObject.get("zahl");
            basis = (int) (long) (Long) jsonObject.get("basis");
        
            Digits theDigits = new Digits(theNumber, basis);
            
            System.out.println("Die Konsolenausgabe der Instanz von Digits " + theDigits);
            out.println("Stellenwertsysteme");
            out.println("------------------------------------------");
            out.println("Die Dezimalzahl, die umgewandelt wird: " + theNumber);
            out.println("Die verwendete Basis: " + theDigits.getBase());            
            out.println("Das Ergebnis");
            out.println("Die Zahl im Stellenwertsystem: " + theDigits);

            out.println("\n");
            out.println("Die Instanz, rekonstruiert im Dezimalsystem: "+ theDigits.numberFromDigits());
            System.out.println("Berechnungen beendet!");            
		}
	}
}