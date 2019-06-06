package analysis.regulaFalsi;

//Java System Klassen
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;



//JSON Parser
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// Funktions Interface und konkrete Realisierung
import analysis.Function;
import analysis.ExampleFunction1;
import analysis.regulaFalsi.RegulaFalsi;

/**
 * Hauptprogramm für die Durchführung der Iteration für die
 * Regula Falsi.
 * <P>
 * Die Eingabewerte für die Durchführung des Algorithmus
 * stehen in der Datei RegulaFalsi.json:
 * Abbruchgenauigkeit epsilon1, epsilon2, Intervallgrenzen
 * a und b, maximale Anzahl der Iterationen.</P>
 *
 * Zur Zeit stehen dort die Werte
 * <P>  
 * "epsilon1" : 0.000005,
 * "epsilon2" : 0.000005,
 * "a"        : 0
 * "b"        : 5
 * "maxIter"  : 100</P>
 * 
 * @author $Author: brill $
 * @version $Revision: #2 $
 */
public class RegulaFalsiMain {

	public static void main(String[] args)throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		File inFile = new File("RegulaFalsi.json"),
			 outFile = new File("RegulaFalsi.out");

		try (PrintWriter out = new PrintWriter(outFile);) {
			// JSON Datei mit den Eingaben parsen
			Object obj = parser.parse(new FileReader(inFile));
						 
			JSONObject jsonObject = (JSONObject) obj;	

            double epsilon1=0.000005, epsilon2 = 0.000005,
            		a=-1.0, b=1.0;
            int maxI=100;

            epsilon1 = (Double) jsonObject.get("epsilon1");
            epsilon2 = (Double) jsonObject.get("epsilon2");
            a = (Double) jsonObject.get("a");
            b = (Double) jsonObject.get("b");	            
            long temp = (Long) jsonObject.get("maxIter");
            maxI = (int)temp;

			// Methode instanziieren
            Function function = new ExampleFunction1();
	        RegulaFalsi regula = new RegulaFalsi(epsilon1, epsilon2, maxI, a, b, function);
            // Berechnung durchführen
	        regula.compute();
            
		    out.println("Ergebnis der Regula Falsi");
		    out.println("-------------------------");
		    out.println("Die verwendete Abbruchgenauigkeit für das Cauchy-Kriterium: " + regula.getEpsilon());
		    out.println("Die verwendete Abbruchgenauigkeit für den Funktionswert: " + regula.getEpsilon2());
		    out.println("Maximale Anzahl der Iterationen: " + regula.getMaxNumberOfIterations());
		    out.println("Anzahl der durchgefuehrten Iterationen: " + regula.getNumberOfIterations());
		    out.println("Das Ergebnis:");
		    out.println("Die Näherung der Nullstelle ist: "+ regula.getResult());
		    out.println("Der Funktionswert an der Näherung ist: " + function.call(regula.getResult()));
		    System.out.println("Berechnungen beendet!");
		}
	}
}
