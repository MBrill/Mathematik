import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.MersenneTwister;

/**
 * Experiment mit sechs blinden W�rfeln.
 * 
 * Wir verwenden sechs entsprechende Instanzen von BlindDice, w�rfeln
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

	
		// Wie oft m�chten wir w�rfeln?
		final int n=10000000;
		final int maxCount = 22;
		/* Wir speichern die absoluten H�ufigkeiten der Zufallsvariable Y
		 * in einem int-Feld.
		 * 
		 * Es gibt 22 m�gliche Ergebnisse, von 0 bis 21.
		 * 
		 * Dabei ist die Augensumme 0 in ergebnis[0],
		 * die Summe 21 in ergebnis[21].
		 */
		int[] ergebnis = new int[maxCount];		
		// Variable f�r die Durchf�hrung
		int value, i, summe;
		
		System.out.println("Wir simulieren " + n + " W�rfe der blinden W�rfel!");
		// W�rfeln mit dem linearen Kongruenz-Generator
		for (i=0; i<n; i++) {
			value = one.throwDice() + two.throwDice() + three.throwDice() 
			          + four.throwDice() + five.throwDice() + six.throwDice();
			ergebnis[value]++;
		}
			
		// Check, ob die Ergebnisse plausibel sind
		// Die Summe der H�ufigkeiten muss mit der Variable n,
		// der Anzahl der Durchf�hrungen,�bereinstimmen.
		summe = 0;
		for (i=0; i<maxCount; i++)
			summe += ergebnis[i];
		
		if (summe != n) {
			System.out.println("Inkonsistentes Ergebnis bei der Simulation der blinden W�rfel!");
			System.out.println("Die Summe der H�ufigkeiten stimmt nicht mit n �berein!");
		}
			
		// Die Ergebnisse ausgeben
		System.out.println("Ergebnisse f�r den blinden W�rfel");
		System.out.println("---------------------------------");		
		printResults(maxCount, ergebnis);
	}
	
	/**
	 * Ausgabe der absoluten H�ufigkeiten als csv-Liste, mit Trenner Semikolon.
	 * 
	 * Es gibt 22 m�gliche Ergebnisse, von der Summe 0 bis zur maximalen Summe 21.
	 * 
	 * @param ergebnis Absolute H�ufigkeiten als int-Array der L�nge 22
	 */
	private static void printResults(int max, int[] ergebnis) 
	{
		System.out.println("Ausgabe der absoluten H�ufigkeiten als csv, Trenner ist Semikolon.\n");
		
		System.out.println("Augensumme; H�ufigkeit");
		for (int i=0; i<max; i++) 
		{
			System.out.println(i + " ; " + ergebnis[i]);
		}
	}					  
}
