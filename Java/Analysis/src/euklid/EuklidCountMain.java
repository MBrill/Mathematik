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
 *   Durchf�hren des Euklidischen Algorithmus mit Instrumentierung
 *   f�r die Analyse des Algorithmus.
 *   <P>
 *   Verwendung: die Eingabedaten (die Zahl a) stehen in der Datei Euklid.json,
 *   die Ergebnisse werden in die Datei Euklid.out geschrieben.
 *   Dabei enh�lt die Ausgabedatei f�r die Fibonacci-Zahl
 *   F_{12} = a = 233 die Anzahl der Divisionen f�r die Berechnung von
 *   ggT(233, b), f�r b = 2, ..., 232, und nat�rlich die Zahl b selbst.
 *   Zus�tzlich wird das Ergebnis, also ggT(233, b), als dritter Eintrag ausgegebe
 *   F�r die bessere Weiterverarbeitung werden Strichpunkte zwischen die
 *   Eintr�ge gesetzt (CSV-Format).
 *   
 *   Die gr��te Anzahl von Durchl�ufen sollte f�r F_{11} = 144 auftauchen!
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
	 * Einlesen der Aufgabenstellung und Algorithmus durchf�hren.
	 */
	public static void main(String[] args) throws IOException
	{
		PrintStream out = null;
		JSONParser parser = new JSONParser();
		try {
			out = new PrintStream(new File("EuklidCount.out"));			// JSON Datei mit den Eingaben parsen			Object obj = parser.parse(new FileReader("EuklidCount.json"));
			JSONObject jsonObject = (JSONObject) obj;
			long a=0, result=0;			a = (Long) jsonObject.get("a");		
			// Euklidischer Algorithmus f�r a und b
			EuklidCount beispiel = new EuklidCount(a);
			out.println("Ergebnis des Euklidischen Algorithmus f�r a = " + beispiel.getA());
			out.println("b   ;  counter  ; Ergebnis");
			// Jetzt b vereinbaren, und sukzessive hochz�hlen			long b;		    // Schleife �ber alle m�glichen b, von 2 bis a-1
			for (b=2; b<a; b++) {
				beispiel.setB(b);
				result = beispiel.gcd();
				out.println(b + " ; " + beispiel.getCounter() + " ; " + result);
			}
			System.out.println("Analyseberechnungen f�r den Euklidischen Algorithmus erfolgreich!");
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