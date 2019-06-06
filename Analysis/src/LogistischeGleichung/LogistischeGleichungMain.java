package analysis.LogistischeGleichung;

/**
 * Hauptprogramm für die Durchführung der Iteration für die
 * logistische Gleichung.
 * <P>
 * Die Eingabewerte für die Durchführung des Algorithmus
 * stehen in der Datei LogistischeGleichung.json:
 * Parameter a,
 * Abbruchgenauigkeit epsilon, 
 * maximale Anzahl der Iterationen.</P>
 *
 * Zur Zeit stehen dort die Werte
 * <P>  
 * "epsilon" : 0.00000000005,
 * "maxIter" : 100
 * "k1"      : 4</P>
 * 
 * @author brill
 * @version $Revision: #3 $
 */

// Java System Klassen
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

//JSON Parser
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LogistischeGleichungMain {

	public static void main(String[] args) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		File inFile = new File("LogistischeGleichung.json"),
			 outFile = new File("LogistischeGleichung.out");

		try (PrintWriter out = new PrintWriter(outFile);) {
			// JSON Datei mit den Eingaben parsen
			Object obj = parser.parse(new FileReader(inFile));
						 
			JSONObject jsonObject = (JSONObject) obj;	

            double  a = 1.3,
                    x0 = 0.1;
			double epsilon=0.00000000005;
            int maxI=100,
            	k1 = 0;

            a = (Double) jsonObject.get("a");
            x0 = (Double) jsonObject.get("x0");
            epsilon = (Double) jsonObject.get("epsilon");
            long temp = (Long) jsonObject.get("maxIter");
            maxI = (int)temp;
            temp = (Long) jsonObject.get("k1");
            k1 = (int)temp;            

			// Methode instanziieren
            LogistischeGleichung logistik = new LogistischeGleichung(a, x0, epsilon, maxI);
            // Berechnung durchführen
            logistik.compute();
            

		    out.println("Ergebnis der Iteration zur logistischen Gleichung");
		    out.println("-------------------------------------------------");
		    out.println("Der Parameter a war " + a);
            out.println("Die verwendete Abbruchgenauigkeit: " + logistik.getEpsilon());		    
            out.println("Maximale Anzahl der Iterationen: " + logistik.getMaxNumberOfIterations());
            out.println("Anzahl der durchgefuehrten Iterationen: " + logistik.getNumberOfIterations());
            out.println("Das Ergebnis:");
		    out.println("\nDer letzte Wert der Iteration: "+ logistik.getValue());

		    // soll feigenbaum aufgerufen werden?
		    // Dies wird nur durchgeführt, falls in der Json-Datei k1 nicht 0 ist!
		    if (k1 > 0) {
		    	int i, n = logistik.getMaxNumberOfIterations();
			    out.println("\nWeitere " + k1 + " Iterationen durchgeführt!");
			    out.println("a    n      x_n");
		    	for (i = 1; i <= k1; i++) {
		    		n++;
		    		out.println(a + "  " + n + "    " + logistik.feigenbaum(1));		    		
		    	} 
		    }
		    System.out.println("Berechnungen beendet!");
		}
	}
}
