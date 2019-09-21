import java.io.*;

// JSON Parser
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *   Hauptprogramm für die Verwendung der Klasse Euklid (Euklidischer Algorithmus)
 *   <P>
 *   Verwendung: die Eingabedaten stehen in der Datei Euklid.json,
 *   die Ergebnisse werden in die Datei Euklid.out geschrieben.</P>
 *   
 *   <P>
 *   Auf der Konsole wird nur Fehler, Warnungen oder eine kurze
 *   Erfolgsmeldung ausgegeben.</P>
 *
 *   $File: //depot/Java/Analysis/src/EuklidMain.java $
 *   $Revision: #3 $
 *   $Date: 2013/03/28 $
 */
public class EuklidMain
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
			out = new PrintStream("Euklid.out");
			// JSON Datei mit den Eingaben parsen
			Object obj = parser.parse(new FileReader("Euklid.json"));
			 
			JSONObject jsonObject = (JSONObject) obj;
			
			long a=0, b=0, result=0;
			a = (Long) jsonObject.get("a");
			b = (Long) jsonObject.get("b");
			
			// Euklidischer Algorithmus für a und b
			Euklid beispiel = new Euklid(a, b);
			result = beispiel.gcd();

			out.println("Ergebnisse");			out.println("----------");			out.println("\n");			out.println("Euklidischer Algorithmus");
			out.println("-------------------------------------");
			out.println("a = " + a + " , b = " + b);
			out.println("ggT(a,b) = " + result);

			System.out.println("Berechnung f�r den Euklidischen Algorithmus erfolgreich!");

			out.println(" ");
			out.println("Verallgemeinerter Euklidischer Algorithmus");
			out.println("------------------------------------------");			
			long[] res = beispiel.extendedGcd();

			out.println("a = " + a + " , b = " + b);
			out.println("ggT(a,b) = " + res[2]);
			out.println("Es gilt: (" + res[0] + ") * " + a + " + (" + res[1] + ") * " + b + " = " + res[2]);
			System.out.println("Berechnung für den verallgemeinerten Euklidischen Algorithmus erfolgreich!");
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


