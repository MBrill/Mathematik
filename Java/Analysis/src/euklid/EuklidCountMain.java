import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

//JSON Parser
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *   Durchführen des Euklidischen Algorithmus mit Instrumentierung
 *   für die Analyse des Algorithmus.
 *   <P>
 *   Verwendung: die Eingabedaten (die Zahl a) stehen in der Datei Euklid.json,
 *   die Ergebnisse werden in die Datei Euklid.out geschrieben.
 *   Dabei enhält die Ausgabedatei für die Fibonacci-Zahl
 *   F_{12} = a = 233 die Anzahl der Divisionen für die Berechnung von
 *   ggT(233, b), für b = 2, ..., 232, und natürlich die Zahl b selbst.
 *   Zusätzlich wird das Ergebnis, also ggT(233, b), als dritter Eintrag ausgegebe
 *   Für die bessere Weiterverarbeitung werden Strichpunkte zwischen die
 *   Einträge gesetzt (CSV-Format).
 *   
 *   Die größte Anzahl von Durchläufen sollte für F_{11} = 144 auftauchen!
 *   </P>
 *   <P>
 *   Auf der Konsole wird nur Fehler, Warnungen oder eine kurze
 *   Erfolgsmeldung ausgegeben.
 *   </P>
 */
public class EuklidCountMain
{
	/**
	 * Hauptprogramm
	 * Einlesen der Aufgabenstellung und Algorithmus durchführen.
	 */
	public static void main(String[] args) throws IOException
	{
		PrintStream out = null;
		JSONParser parser = new JSONParser();
		try {
			out = new PrintStream(new File("EuklidCount.out"));			// JSON Datei mit den Eingaben parsen			Object obj = parser.parse(new FileReader("EuklidCount.json"));
			JSONObject jsonObject = (JSONObject) obj;
			long a=0, result=0;			a = (Long) jsonObject.get("a");		
			// Euklidischer Algorithmus für a und b
			EuklidCount beispiel = new EuklidCount(a);
			out.println("Ergebnis des Euklidischen Algorithmus für a = " + beispiel.getA());
			out.println("b   ;  counter  ; Ergebnis");
			// Jetzt b vereinbaren, und sukzessive hochzählen			long b;		    // Schleife über alle möglichen b, von 2 bis a-1
			for (b=2; b<a; b++) {
				beispiel.setB(b);
				result = beispiel.gcd();
				out.println(b + " ; " + beispiel.getCounter() + " ; " + result);
			}
			System.out.println("Analyseberechnungen für den Euklidischen Algorithmus erfolgreich!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		finally {
			if (out != null) out.close();
		}
	}
}