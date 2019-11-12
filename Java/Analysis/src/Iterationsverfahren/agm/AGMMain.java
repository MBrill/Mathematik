package Iterationsverfahren.agm;

//JSON Parser Java Systemklassen
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Calendar;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * 
 * Hauptprogramm für die Durchführung der Klasse AGM.
 * <p>
 * Die Eingabewerte für die Durchführung des Algorithmus stehen in der Datei AGM.json mit den folgenden Keys: Startwert a,
 * Startwert b, Abbruchgenauigkeit epsilon, maximale Anzahl der Iterationen maxIter.
 * </p>
 */
public final class AGMMain {

    public static void main(String[] args) throws IOException, IOException, ParseException {
        JSONParser parser = new JSONParser();

        File inFile = new File("AGM.json");
        File outFile = new File("AGM.out");
        try(PrintStream out = new PrintStream(outFile)) {
            // JSON Datei mit den Eingaben parsen
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(inFile));

            double starta = 0.0;
            double startb = 1.0;
            double epsilon = 0.00005;
            int maxIterations = 4;

            starta = (Double) jsonObject.get("a");
            startb = (Double) jsonObject.get("b");
            epsilon = (Double) jsonObject.get("epsilon");
            maxIterations = (int) ((long) jsonObject.get("maxIter"));

            // Methode instanziieren
            AGM agm = new AGM(epsilon, maxIterations, starta, startb);

            // Berechnung durchführen
            agm.compute();
            out.println("Ergebnis der AGM-Iteration (" + Calendar.getInstance().getTime() + ")");
            out.println("--------------------------");
            out.println("Startwert a = " + starta);
            out.println("Startwert b = " + startb);
            out.println("Die verwendete Abbruchgenauigkeit: " + agm.getEpsilon());
            out.println("Maximale Anzahl der Iterationen: " + agm.getMaxNumberOfIterations());
            out.println("Anzahl der durchgefuehrten Iterationen: " + agm.getNumberOfIterations());
            out.println("Das Ergebnis:");
            out.println("a = " + agm.getA());
            out.println("b = " + agm.getB());
            out.println("Die Differenz der beiden Werte: " + Math.abs(agm.getA() - agm.getB()));
            System.out.println("Berechnungen durchgefuehrt!");
        }
    }
}
