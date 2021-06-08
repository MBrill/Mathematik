import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.MersenneTwister;

/**
 * Experiment zweimal Würfeln und Augensumme berechnen.
 * 
 * Das Experiment wird zweimal ausgef�hrt. Einmal mit einer Instanz von
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
		
		/* Wir speichern die absoluten Häufigkeiten in einem int-Feld
		 * Dabei ist die Augensumme 2 in ergebnis[0],
		 * die Summe 3 in ergebnis[1] und allgemein
		 * die Summe k in ergebnis[k-2].
		 * Insgesamt ben�tigen wir 11 Feldelemente 
		 */
		int[] ergebnis = new int[11];
		// Wie oft m�chten wir w�rfeln?
		final int n=100000;
		// Variable f�r Berechnungen
		int value, i, summe;
		
		System.out.println("Wir simulieren " + n + " W�rfe mit Hilfe des Lehner-Generators!");
		// 1. W�rfeln mit dem linearen Kongruenz-Generator
		for (i=0; i<n; i++) {
			value = experiment1.throwDies();
			ergebnis[value-2]++;
		}
			
		// Check, ob die Ergebnisse plausibel sind
		// Die Summe der Häufigkeiten muss mit der Variable n,
		// der Anzahl der Durchf�hrungen,�bereinstimmen.
		summe = 0;
		for (i=0; i<11; i++)
			summe += ergebnis[i];
		
		if (summe != n) {
			System.out.println("Inkonsistentes Ergebnis bei der Simulation mit dem Lehmer-Generator!");
			System.out.println("Die Summe der H�ufigkeiten stimmt nicht mit n �berein!");
		}
			
		// Die Ergebnisse ausgeben
		System.out.println("Ergebnisse mit dem linearen Kongruenz-Generator");
		System.out.println("-----------------------------------");		
		printResults(ergebnis);
		System.out.println("\n");
		
		// Experiment wiederholen, jetzt mit einem MersenneTwister		
		// Häufigkeiten zur�cksetzen
		for (i=0; i<11; i++) 
			ergebnis[i] = 0;
		System.out.println("Wir simulieren " + n + " W�rfe mit Hilfe eines Mersenne-Twisters!");
		for (i=0; i<n; i++) {
			value = experiment2.throwDies();
			ergebnis[value-2]++;
		}
		
		// Check, ob die Ergebnisse plausibel sind
		// Die Summe der Häufigkeiten muss mit der Variable n,
		// der Anzahl der Durchführungen, übereinstimmen.
		summe = 0;
		for (i=0; i<11; i++)
			summe += ergebnis[i];
		
		if (summe != n) {
			System.out.println("Inkonsistentes Ergebnis bei der Simulation mit dem  Mersenne-Twister!");
			System.out.println("Die Summe der Häufigkeiten stimmt nicht mit n überein!");
		}
				
		// Die Ergebnisse ausgeben
		System.out.println("Ergebnisse mit dem Mersenne Twister");
		System.out.println("-----------------------------------");
		printResults(ergebnis);
	}
	
	/**
	 * Ausgabe der absoluten H�ufigkeiten als csv-Liste, mit Trenner Semikolon.ä
	 * 
	 * Es gibt 11 mögliche Ergebnisse, von der Summe 2 bis zur maximalen Summe 12.
	 * 
	 * @param ergebnis Absolute Häufigkeiten als int-Array der Länge 11
	 */
	private static void printResults(int[] ergebnis) 
	{
		System.out.println("Ausgabe der absoluten Häufigkeiten als csv, Semikolon ist der Trenner.");
		
		for (int i=0; i<10; i++) {
			System.out.print(ergebnis[i] + ";");
		// Letzte H�ufigkeit ohne Semikolon
		System.out.print(ergebnis[10]);
	}
}
}
