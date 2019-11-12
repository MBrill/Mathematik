package Iterationsverfahren.brentSalamin;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

//JSON Parser
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Hauptprogramm für die Durchführung des Brent-Salamin-Verfahrens
 * zur Annäherung der irrationalen Zahl pi.
 * 
 * Die Eingabewerte für die Durchführung des Algorithmus
 * stehen in der Datei BrentSalamin.json:
 * Abbruchgenauigkeit epsilon, maximale Anzahl der Iterationen.
 *
 * Zur Zeit stehen dort die Werte
 * <P>  
 * "epsilon" : 0.00000000005,
 * "maxIter" : 100
 * </P>
 */
public class BrentSalaminMain {

	public static void main(String[] args) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		File inFile = new File("BrentSalamin.json"),
			 outFile = new File("BrentSalamin.out");
		
		try (PrintWriter out = new PrintWriter(outFile);) {
			// JSON Datei mit den Eingaben parsen
			Object obj = parser.parse(new FileReader(inFile));
						 

			JSONObject jsonObject = (JSONObject) obj;		

            double epsilon=0.00005;
            int maxI=4;

            epsilon = (Double) jsonObject.get("epsilon");
            long temp = (Long) jsonObject.get("maxIter");
            maxI = (int)temp;

			// Methode instanziieren
	        BrentSalamin computePi = new BrentSalamin(epsilon, maxI);
            // Berechnung durchführen
	        computePi.compute();
            

		    out.println("Ergebnis von Brent-Salamin");
		    out.println("------------------------------");
		    out.println("Die verwendete Abbruchgenauigkeit: " + computePi.getEpsilon());
		    out.println("Maximale Anzahl der Iterationen: " + computePi.getMaxNumberOfIterations());
		    out.println("Anzahl der durchgefuehrten Iterationen: " + computePi.getNumberOfIterations());
		    out.println("Das Ergebnis:");
		    out.println("pi ist angenaehert als "+ computePi.getPi());
		    out.println("Absoluter Fehler zu Math.PI: " + Math.abs(computePi.getPi()-Math.PI));
		    out.println("Relativer Fehler zu Math.PI: " + Math.abs(computePi.getPi()-Math.PI)/Math.PI);
		    System.out.println("Berechnungen beendet!");					
		}
	}
}
