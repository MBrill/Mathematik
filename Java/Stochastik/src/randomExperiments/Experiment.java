import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.MersenneTwister;

/**
 * Experiment zweimal WÃürfeln und Augensumme berechnen.
 * 
 * Das Experiment wird zweimal ausgeführt. Einmal mit einer Instanz von
 * LinearCongruentalGenerator, und einmal mit einer Instanz eines MersenneTwisters
 * aus der Apache Common Math API.
 */
public class Experiment 
{
	public static void main(String[] args) {
		// Mersenne Twister erzeugen
		MersenneTwister twister = new MersenneTwister();
		// Zufallszahlen-Generator erzeugen mit MersenneTwister-Instanz
		RandomDataGenerator genTwist= new RandomDataGenerator(twister);
		// Der Kongruenz-Generator verwendet die originalDaten von Lehmer!
		LinearCongruentalGenerator genLin = new LinearCongruentalGenerator();
		
		TwoDiesCongruental experiment1 = new TwoDiesCongruental(genLin);
		TwoDiesTwister     experiment2 = new TwoDiesTwister(genTwist);
		
		/* Wir speichern die absoluten HÃ¤ufigkeiten in einem int-Feld
		 * Dabei ist die Augensumme 2 in ergebnis[0],
		 * die Summe 3 in ergebnis[1] und allgemein
		 * die Summe k in ergebnis[k-2].
		 * Insgesamt benötigen wir 11 Feldelemente 
		 */
		int[] ergebnis = new int[11];
		// Wie oft möchten wir würfeln?
		final int n=100000;
		// Variable für Berechnungen
		int value, i, summe;
		
		System.out.println("Wir simulieren " + n + " Würfe mit Hilfe des Lehner-Generators!");
		// 1. Würfeln mit dem linearen Kongruenz-Generator
		for (i=0; i<n; i++) {
			value = experiment1.throwDies();
			ergebnis[value-2]++;
		}
			
		// Check, ob die Ergebnisse plausibel sind
		// Die Summe der HÃ¤ufigkeiten muss mit der Variable n,
		// der Anzahl der Durchführungen,übereinstimmen.
		summe = 0;
		for (i=0; i<11; i++)
			summe += ergebnis[i];
		
		if (summe != n) {
			System.out.println("Inkonsistentes Ergebnis bei der Simulation mit dem Lehmer-Generator!");
			System.out.println("Die Summe der Häufigkeiten stimmt nicht mit n überein!");
		}
			
		// Die Ergebnisse ausgeben
		System.out.println("Ergebnisse mit dem linearen Kongruenz-Generator");
		System.out.println("-----------------------------------");		
		printResults(ergebnis);
		System.out.println("\n");
		
		// Experiment wiederholen, jetzt mit einem MersenneTwister		
		// HÃ¤ufigkeiten zurï¿½cksetzen
		for (i=0; i<11; i++) 
			ergebnis[i] = 0;
		System.out.println("Wir simulieren " + n + " Würfe mit Hilfe eines Mersenne-Twisters!");
		for (i=0; i<n; i++) {
			value = experiment2.throwDies();
			ergebnis[value-2]++;
		}
		
		// Check, ob die Ergebnisse plausibel sind
		// Die Summe der HÃ¤ufigkeiten muss mit der Variable n,
		// der Anzahl der DurchfÃ¼hrungen, Ã¼bereinstimmen.
		summe = 0;
		for (i=0; i<11; i++)
			summe += ergebnis[i];
		
		if (summe != n) {
			System.out.println("Inkonsistentes Ergebnis bei der Simulation mit dem  Mersenne-Twister!");
			System.out.println("Die Summe der HÃ¤ufigkeiten stimmt nicht mit n Ã¼berein!");
		}
				
		// Die Ergebnisse ausgeben
		System.out.println("Ergebnisse mit dem Mersenne Twister");
		System.out.println("-----------------------------------");
		printResults(ergebnis);
	}
	
	/**
	 * Ausgabe der absoluten Hï¿½ufigkeiten als csv-Liste, mit Trenner Semikolon.Ã¤
	 * 
	 * Es gibt 11 mÃ¶gliche Ergebnisse, von der Summe 2 bis zur maximalen Summe 12.
	 * 
	 * @param ergebnis Absolute HÃ¤ufigkeiten als int-Array der LÃ¤nge 11
	 */
	private static void printResults(int[] ergebnis) 
	{
		System.out.println("Ausgabe der absoluten HÃ¤ufigkeiten als csv, Semikolon ist der Trenner.");
		
		for (int i=0; i<10; i++) {
			System.out.print(ergebnis[i] + ";");
		// Letzte Hï¿½ufigkeit ohne Semikolon
		System.out.print(ergebnis[10]);
	}
}
}
