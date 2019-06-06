package analysis.bisektion;

//Java System Klassen
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


//JSON Parser
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Kubische Parabel als Beispielfunktion: f(x) = x^3 - 8
 */
import analysis.Function;
import analysis.bisektion.CubicFunction;

/**
 * Hauptprogramm für die Durchführung der Iteration für die
 * Bisektion.
 * <P>
 * Die Eingabewerte für die Durchführung des Algorithmus
 * stehen in der Datei Bisektion.json:
 * Parameter epsilon1 (Intervalllänge),
 * Abbruchgenauigkeit epsilon2 (Funktionswert),
 * a, b Startintervall, 
 * maximale Anzahl der Iterationen.</P>
 *
 * Zur Zeit stehen dort die Werte
 * <P>  
 * "epsilon1" : 0.000005,
 * "epsilon2" : 0.000005, 
 * "a"        : 0.0,
 * "b"        : 5.0, 
 * "maxIter"  : 100/P>
 * 
 * @author $Author: brill $
 * @version $Revision: #2 $
 */
public class BisektionMain {

	public static void main(String[] args)throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		File inFile = new File("Bisektion.json"),
			 outFile = new File("Bisektion.out");

		try (PrintWriter out = new PrintWriter(outFile);) {
			// JSON Datei mit den Eingaben parsen
			Object obj = parser.parse(new FileReader(inFile));
						 
			JSONObject jsonObject = (JSONObject) obj;	

            double epsilon1=0.000005, epsilon2 = 0.000005,
            	   a=0.0, b=1.0;
            int maxI=100;

            epsilon1 = (Double) jsonObject.get("epsilon1");
            epsilon2 = (Double) jsonObject.get("epsilon2");
            a = (Double) jsonObject.get("a");
            b = (Double) jsonObject.get("b");	            
            long temp = (Long) jsonObject.get("maxIter");
            maxI = (int)temp;

			// Methode instanziieren
            Function function = new CubicFunction();
	        Bisektion bisekt = new Bisektion(epsilon1, epsilon2, maxI, a, b, function);
            // Berechnung durchführen
	        bisekt.compute();
            
		    out.println("Ergebnis der Bisektion");
		    out.println("----------------------");
		    out.println("Die verwendete Abbruchgenauigkeit für die Laenge des Intervalls: " + bisekt.getEpsilon());
		    out.println("Die verwendete Abbruchgenauigkeit für den Funktionswert: " + bisekt.getEpsilon2());
		    out.println("Maximale Anzahl der Iterationen: " + bisekt.getMaxNumberOfIterations());
		    out.println("Anzahl der durchgefuehrten Iterationen: " + bisekt.getNumberOfIterations());
		    out.println("Das Ergebnis:");
		    out.println("Die Näherung der Nullstelle ist: "+ bisekt.getResult());
		    out.println("Der Funktionswert an der Näherung ist: " + function.call(bisekt.getResult()));
		    System.out.println("Berechnungen beendet!");
		}
	}
}
