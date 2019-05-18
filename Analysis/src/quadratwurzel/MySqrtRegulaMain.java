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
 * Hauptprogramm für die Durchführung der Berechnung einer Wurzel
 * von reellen Zahlen mit Hilfe der Regula Falsi.
 * <P>
 * Die Eingabewerte für die Durchführung des Algorithmus
 * stehen in der Datei MySqrtRegula.json:
 * Radikand,
 * Abbruchgenauigkeit epsilon1 und epsilon2, maximale Anzahl der Iterationen.</P>
 *
 * Zur Zeit stehen dort die Werte
 * <P>  
 * "radikand" : 4.0
 * "epsilon1" : 0.00005,
 * "epsilon2" : 0.00005, * 
 * "maxIter" : 100</P>
 * 
 * @author Manfred Brill
 * @version $Revision: #1 $
 * $Date: 2013/07/11 $
 */

public class MySqrtRegulaMain {
	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		PrintStream out = null;
		File inFile = new File("MySqrtRegula.json"),
			 outFile = new File("MySqrtRegula.out");

		try {
			// JSON Datei mit den Eingaben parsen
			Object obj = parser.parse(new FileReader(inFile));
						 
			JSONObject jsonObject = (JSONObject) obj;
			out = new PrintStream(outFile);			

            double r = 4.0, epsilon1=0.00005, epsilon2 = 0.00005;
            int maxI=100;

            r = (Double) jsonObject.get("radikand");            
            epsilon1 = (Double) jsonObject.get("epsilon1");	   
            epsilon2 = (Double) jsonObject.get("epsilon2");
            long temp = (Long) jsonObject.get("maxIter");
            maxI = (int)temp;

			// Methode instanziieren
	        MySqrtRegula mySqrt = new MySqrtRegula(epsilon1, epsilon2, maxI, r);
            // Berechnung durchführen
	        mySqrt.compute();
            

		    out.println("Ergebnis der Wurzelberechnung mit Hilfe der Regula Falsi");
		    out.println("--------------------------------------------------------");
		    out.println("Die verwendete Abbruchgenauigkeit für das Cauchy-Kriterium: " + mySqrt.getEpsilon());
		    out.println("Die verwendete Abbruchgenauigkeit für den Funktionswert: " + mySqrt.getEpsilon2());
		    out.println("Maximale Anzahl der Iterationen: " + mySqrt.getMaximumNumberOfIterations());
		    out.println("Anzahl der durchgefuehrten Iterationen: " + mySqrt.getNumberOfIterations());
		    out.println("Das Ergebnis:");
		    out.println("Die Näherung der Wurzel aus " + r + " ist: "+ mySqrt.getResult());
		    out.println("Das Quadrat der Näherung: " + mySqrt.getResult()*mySqrt.getResult() );
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
