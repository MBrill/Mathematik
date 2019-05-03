package analysis.archimedes;

//JSON Parser und Java Systemklassen
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Hauptprogramm für die Durchführung des Archimedes-Verfahrens zur Annäherung der irrationalen Zahl pi.
 * <P>
 * Die Eingabewerte für die Durchführung des Algorithmus stehen in der Datei Archimedes.json: 
 * Abbruchgenauigkeit epsilon, 
 * maximale Anzahl der Iterationen.
 * </P>
 * 
 * 
 * @author $Author: brill $
 * @version $Revision: #5 $
 */
public class ArchimedesMain {

    public static void main(String[] args) throws IOException, ParseException {
        JSONParser parser = new JSONParser();

        File inFile = new File("Archimedes.json");
        File outFile = new File("Archimedes.out");
        try(PrintWriter out = new PrintWriter(outFile);) {
            // JSON Datei mit den Eingaben parsen
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(inFile));

            double epsilon = (Double) jsonObject.get("epsilon");
            int maxIterations = (int) (long) (Long) jsonObject.get("maxIter");

            // Verfahren instanziieren
            Archimedes computePi = new Archimedes(epsilon, maxIterations);
            // Berechnung durchführen
            computePi.compute();

            out.println("Ergebnis der des Verfahrens von Archimedes");
            out.println("------------------------------------------");
            out.println("Die verwendete Abbruchgenauigkeit: " + computePi.getEpsilon());
            out.println("Maximale Anzahl der Iterationen: " + computePi.getMaxNumberOfIterations());
            out.println("Anzahl der durchgefuehrten Iterationen: " + computePi.getNumberOfIterations());
            out.println("Das Ergebnis:");
            out.println("pi ist angenaehert als " + computePi.getPi());
            out.println("Absoluter Fehler zu Math.PI: " + Math.abs(computePi.getPi() - Math.PI));
            out.println("Relativer Fehler zu Math.PI: " + Math.abs(computePi.getPi() - Math.PI) / Math.PI);
            System.out.println("Berechnungen beendet!");

        }
    }
}
