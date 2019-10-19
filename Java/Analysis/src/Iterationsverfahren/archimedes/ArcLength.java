package Iterationsverfahren.archimedes;

//JSON Parser und Java Systemklassen
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Hauptprogramm für die Näherung des Umfangs des Einheitskreises..
 * 
 * Die Eingabewerte für die Durchführung des Algorithmus stehen in der Datei Archimedes.json: 
 * Abbruchgenauigkeit epsilon, 
 * maximale Anzahl der Iterationen.
 */
public class ArcLength {

    public static void main(String[] args) throws IOException, ParseException {
        JSONParser parser = new JSONParser();

        File inFile = new File("Archimedes.json");
        File outFile = new File("ArcLength.out");
        try(PrintWriter out = new PrintWriter(outFile);) {
            // JSON Datei mit den Eingaben parsen
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(inFile));

            double epsilon = (Double) jsonObject.get("epsilon");
            int maxIterations = (int) (long) (Long) jsonObject.get("maxIter");

            // Verfahren instanziieren
            Archimedes computePi = new Archimedes(epsilon, maxIterations);
           
            // Wir berechnen mit Hilfe von 2*a die Näherung für den Umfang des Kreises
            out.println("Ergebnis der des Verfahrens von Archimedes für den Umfang");
            out.println("------------------------------------------");
            out.println("Die verwendete Abbruchgenauigkeit: " + computePi.getEpsilon());
            out.println("Anzahl der durchgefuehrten Iterationen: " + computePi.getNumberOfIterations());
            out.println("Der Umfang ist angenaehert als " + computePi.getArcLength());
            System.out.println("Berechnungen beendet!");
        }
    }
}
