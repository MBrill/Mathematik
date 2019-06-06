package analysis.quadratwurzel;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

//JSON Parser
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * 
 * Hauptprogramm für die iterative Berechnung einer Quadratwurzel.
 * <P>
 * Die Eingabewerte für die Durchführung des Algorithmus stehen in der Datei Quadratwurzel.json mit den folgenden Schlüsseln:
 * "Startwert", Zahl, aus der die Wurzel gezogen wird ("radikand"), Abbruchgenauigkeit "epsilon", maximale Anzahl der Iterationen
 * "maxIter".
 * </P>
 * 
 * @author Manfred Brill, Patrick Schwartz
 * @version $Revision: #4 $
 */
public class QuadratwurzelMain {

    // Exception Handling in main ist hier sinnlos.
    public static void main(String[] args) throws IOException, ParseException {
        JSONParser parser = new JSONParser();

        File inFile = new File("Quadratwurzel.json");
        File outFile = new File("Quadratwurzel.out");

        try(PrintWriter out = new PrintWriter(outFile);) {

            // JSON Datei mit den Eingaben parsen
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(inFile));

            double starta = 0.0;
            double r = 2.0;
            double epsilon = 0.00005;
            int maxIterations = 4;

            starta = (double) jsonObject.get("startwert");
            r = (double) jsonObject.get("radikand");
            epsilon = (double) jsonObject.get("epsilon");
            maxIterations = (int) ((long) jsonObject.get("maxIter")); // Long -> long -> int nice job java

            // Verfahren instanziieren
            QuadratWurzel wurzel = new QuadratWurzel(starta, epsilon, maxIterations);
            wurzel.setRadikand(r);

            // Berechnung durchführen
            wurzel.compute();

            // Ausgaben
            out.println("Ergebnis der Quadratwurzel-Iteration (" + Calendar.getInstance().getTime() + ")");
            out.println("------------------------------------");
            out.println("Startwert a: " + starta);
            out.println("Zahl, für die die Wurzel berechnet wird: " + r);
            out.println("Die verwendete Abbruchgenauigkeit: " + wurzel.getEpsilon());
            out.println("Maximale Anzahl der Iterationen: " + wurzel.getMaxNumberOfIterations());
            out.println("Anzahl der durchgefuehrten Iterationen: " + wurzel.getNumberOfIterations());
            out.println("Das Ergebnis:");
            out.println("a = " + wurzel.getA());
            out.println("Absoluter Fehler: " + Math.abs(wurzel.getA() - Math.sqrt(r)));
            if(r != 0.0)
                out.println("Relativer Fehler: " + Math.abs(wurzel.getA() - Math.sqrt(r)) / Math.sqrt(r));
            System.out.println("Berechnungen beendet!");

        }
    }
}