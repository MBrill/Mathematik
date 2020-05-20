import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.MersenneTwister;

/**
 * Experiment mit sechs blinden Würfeln.
 * 
 * Wir verwenden sechs entsprechende Instanzen von BlindDice, würfeln
 * und addieren die realisierten Augen.
 */
public class BlindDiceExperiment 
{
	public static void main(String[] args) 
	{
		// Mersenne Twister erzeugen
		MersenneTwister twister = new MersenneTwister();
		// Zufallszahlen-Generator erzeugen mit MersenneTwister-Instanz
		RandomDataGenerator genTwist= new RandomDataGenerator(twister);
		
		// Die sechs blinden W�rfel erzeugen
	    BlindDice one = new BlindDice(1, genTwist),
				  two = new BlindDice(2, genTwist),
				  three = new BlindDice(3, genTwist),
				  four = new BlindDice(4, genTwist),				  
				  five = new BlindDice(5, genTwist),
				  six = new BlindDice(6, genTwist);		

	
		// Wie oft möchten wir würfeln?
		final int n=10000000;
		final int maxCount = 22;
		/* 
		 * Wir speichern die absoluten Häufigkeiten der Zufallsvariable Y
		 * in einem int-Feld.
		 * 
		 * Es gibt 22 mögliche Ergebnisse, von 0 bis 21.
		 * 
		 * Dabei ist die Augensumme 0 in ergebnis[0],
		 * die Summe 21 in ergebnis[21].
		 */
		int[] ergebnis = new int[maxCount];		
		// Variable f�r die Durchführung
		int value, i, summe;
		
		System.out.println("Wir simulieren " + n + " Würfe der blinden Würfel!");
		// Würfeln mit dem linearen Kongruenz-Generator
		for (i=0; i<n; i++) {
			value = one.throwDice() + two.throwDice() + three.throwDice() 
			          + four.throwDice() + five.throwDice() + six.throwDice();
			ergebnis[value]++;
		}
			
		// Check, ob die Ergebnisse plausibel sind
		// Die Summe der Häufigkeiten muss mit der Variable n,
		// der Anzahl der Durchführungen, übereinstimmen.
		summe = 0;
		for (i=0; i<maxCount; i++)
			summe += ergebnis[i];
		
		if (summe != n) {
			System.out.println("Inkonsistentes Ergebnis bei der Simulation der blinden Würfel!");
			System.out.println("Die Summe der Häufigkeiten stimmt nicht mit n überein!");
		}
			
		// Die Ergebnisse ausgeben
		System.out.println("Ergebnisse f�r den blinden Würfel");
		System.out.println("---------------------------------");		
		printResults(maxCount, ergebnis);
	}
	
	/**
	 * Ausgabe der absoluten Häufigkeiten als csv-Liste, mit Semikolon als Trenner.
	 * 
	 * Es gibt 22 mögliche Ergebnisse, von der Summe 0 bis zur maximalen Summe 21.
	 * 
	 * @param ergebnis Absolute Häufigkeiten als int-Array der Länge 22
	 */
	private static void printResults(int max, int[] ergebnis) 
	{
		System.out.println("Ausgabe der absoluten Häufigkeiten als csv, Trenner ist Semikolon.\n");
		
		System.out.println("Augensumme; Häufigkeit");
		for (int i=0; i<max; i++) 
		{
			System.out.println(i + " ; " + ergebnis[i]);
		}
	}					  
}
