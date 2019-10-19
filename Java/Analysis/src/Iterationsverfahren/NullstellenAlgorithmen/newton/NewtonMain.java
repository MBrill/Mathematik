package Iterationsverfahren.NullstellenAlgorithmen.newton;

//Java System Klassen
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

//JSON Parser
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


//Funktions Interface und konkrete Realisierung
import Iterationsverfahren.NullstellenAlgorithmen.Function;
import Iterationsverfahren.NullstellenAlgorithmen.ExampleFunction1;
import Iterationsverfahren.NullstellenAlgorithmen.ExampleDerivative1;
import Iterationsverfahren.NullstellenAlgorithmen.newton.Newton;

/**
 * Hauptprogramm für die Durchführung der Iteration für das
 * Newtonverfahren.
 * 
 * <P> * Die Eingabewerte für die Durchführung des Algorithmus
 * stehen in der Datei Newton.json:
 * Abbruchgenauigkeit epsilon1, epsilon2, Intervallgrenzen
 * a und b, maximale Anzahl der Iterationen.</P>
 *
 * Zur Zeit stehen dort die Werte
 * <P>  
 * "epsilon1" : c,
 * "epsilon2" : 0.0000005,
 * "x0"        : 1.0
 * "maxIter"  : 100</P>
 */
public class NewtonMain {

	public static void main(String[] args)throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		File inFile = new File("Newton.json"),
			 outFile = new File("Newton.out");
		
		try (PrintWriter out = new PrintWriter(outFile);) {
			// JSON Datei mit den Eingaben parsen
			Object obj = parser.parse(new FileReader(inFile));
						 
			JSONObject jsonObject = (JSONObject) obj;	

			double epsilon1 = 0.0000005, 
				   epsilon2 = 0.0000005,
            	   x0 = 1.0;
            int maxI=100;

            epsilon1 = (Double) jsonObject.get("epsilon1");
            epsilon2 = (Double) jsonObject.get("epsilon2");
            x0 = (Double) jsonObject.get("x0");          
            long temp = (Long) jsonObject.get("maxIter");
            maxI = (int)temp;

			// Methode instanziieren
            Function function = new ExampleFunction1();
            Function derivative = new ExampleDerivative1();
            
	        Newton newton = new Newton(epsilon1, epsilon2, maxI, x0, function, derivative);
            // Berechnung durchführen
	        newton.compute();
            
		    out.println("Ergebnis des Newton-Verfahrens");
		    out.println("-------------------------");
		    out.println("Die verwendete Abbruchgenauigkeit für das Cauchy-Kriterium: " + newton.getEpsilon());
		    out.println("Die verwendete Abbruchgenauigkeit für den Funktionswert: " + newton.getEpsilon2());
		    out.println("Maximale Anzahl der Iterationen: " + newton.getMaxNumberOfIterations());
		    out.println("Anzahl der durchgefuehrten Iterationen: " + newton.getNumberOfIterations());
		    out.println("Das Ergebnis:");
		    out.println("Die Näherung der Nullstelle ist: "+ newton.getResult());
		    out.println("Der Funktionswert an der Näherung ist: " + function.call(newton.getResult()));
		    System.out.println("Berechnungen beendet!");
		}		
	}	

}
