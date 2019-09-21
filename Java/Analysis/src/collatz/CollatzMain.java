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
 *
 * Hauptprogramm für die Durchführung Collatz-Folge.
 * <P>
 * Die Eingabewerte für die Durchführung des Algorithmus
 * stehen in der Datei Collatz.json in der folgenden Reihenfolge:
 * Startwert mit Schlüssel "startwert"</P>
 *
 * @author Manfred Brill
 * @version 1.0 
 */
public class CollatzMain {	
	public static void main(String[] args) throws IOException
	{
		JSONParser parser = new JSONParser();
		PrintStream out = null;
		File inFile = new File("Collatz.json"),
			 outFile = new File("Collatz.out");			
		try {
			out = new PrintStream(outFile);
			// JSON Datei mit den Eingaben parsen
			Object obj = parser.parse(new FileReader(inFile));		 
			JSONObject jsonObject = (JSONObject) obj;		
            double starta=0.0;           
            starta = (Double) jsonObject.get("startwert");			
			// Methode instanziieren
	        Collatz folge = new Collatz(starta);
            // Berechnung durchführen
            folge.compute();            
		    out.println("Berechnung einer Collatz-Folge");
		    out.println("------------------------------");
		    int max = folge.getNumberOfIterations();
		    out.println("Laenge der Collatz-Folge: " + max);
		    out.println("\nDie berechnete Folge:");
		    for (int i=0; i<max-1; i++) {
		    	out.print(folge.getNumber(i)+ ", ");
		    }
		    out.print("1");
		    System.out.println("Berechnungen beendet!");
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