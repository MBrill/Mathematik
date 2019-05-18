package numbers.factors;

/**
 * Hauptprogramm für die Berechnung aller Teiler einer angegebenen Zahl.
 * 
 * Die Ausgabe der Ergebnisse wurde verändert. Im Modula2-Beispiel
 * werden die gefundenen Teiler direkt auf die Konsole geschrieben.
 * Hier wird prinzipiell die Funktion toString der Berechnungsklasse
 * überschrieben und im Hauptprogramm wird eine Konsolenausgabe 
 * verwendet.
 * <p>
 * Dadurch wurde es auch nötig, den Fall einer Primzahl anders zu behandeln
 * als in der Modula2-Vorlage. Ist die Liste der Teiler leer, dann wird
 * mitgeteilt, dass die behandelte Zahl prim ist.
 * 
 * @author  $Author: brill $
 * @version $Revision: #3 $
 */
public class FactorsMain {

	public static void main(String[] args) {
		
		Long number = (long)12;
		ComputeFactors factors = new ComputeFactors(number);
		factors.compute();
		
		System.out.println(factors);
	}
}
