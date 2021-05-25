import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.MersenneTwister;

/**
 * Experiment mit sechs blinden Wï¿½rfeln.
 * 
 * Wir verwenden sechs entsprechende Instanzen von BlindDice, wÃ¼rfeln
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
		
		// Die sechs blinden Wï¿½rfel erzeugen
	    BlindDice one = new BlindDice(1, genTwist),
				  two = new BlindDice(2, genTwist),
				  three = new BlindDice(3, genTwist),
				  four = new BlindDice(4, genTwist),				  
				  five = new BlindDice(5, genTwist),
				  six = new BlindDice(6, genTwist);		

	
		// Wie oft mï¿½hten wir wï¿½rfeln?
		final int n=10000000;
		final int maxCount = 22;
		/* 
		 * Wir speichern die absoluten HÃ¤ufigkeiten der Zufallsvariable Y
		 * in einem int-Feld.
		 * 
		 * Es gibt 22 mï¿½gliche Ergebnisse, von 0 bis 21.
		 * 
		 * Dabei ist die Augensumme 0 in ergebnis[0],
		 * die Summe 21 in ergebnis[21].
		 */
		int[] ergebnis = new int[maxCount];		
		// Variable fï¿½r die DurchfÃ¼hrung
		int value, i, summe;
		
		System.out.println("Wir simulieren " + n + " Würfe der blinden Würfel!");
		// WÃ¼rfeln mit dem linearen Kongruenz-Generator
		for (i=0; i<n; i++) {
			value = one.throwDice() + two.throwDice() + three.throwDice() 
			          + four.throwDice() + five.throwDice() + six.throwDice();
			ergebnis[value]++;
		}
			
		// Check, ob die Ergebnisse plausibel sind
		// Die Summe der Häufigkeiten muss mit der Variable n,
		// der Anzahl der Durchführungen, Ã¼bereinstimmen.
		summe = 0;
		for (i=0; i<maxCount; i++)
			summe += ergebnis[i];
		
		if (summe != n) {
			System.out.println("Inkonsistentes Ergebnis bei der Simulation der blinden WÃ¼rfel!");
			System.out.println("Die Summe der HÃ¤ufigkeiten stimmt nicht mit n Ã¼berein!");
		}
			
		// Die Ergebnisse ausgeben
		System.out.println("Ergebnisse fï¿½r den blinden WÃ¼rfel");
		System.out.println("---------------------------------");		
		printResults(maxCount, ergebnis);
	}
	
	/**
	 * Ausgabe der absoluten HÃ¤ufigkeiten als csv-Liste, mit Semikolon als Trenner.
	 * 
	 * Es gibt 22 mÃ¶gliche Ergebnisse, von der Summe 0 bis zur maximalen Summe 21.
	 * 
	 * @param ergebnis Absolute HÃ¤ufigkeiten als int-Array der LÃ¤nge 22
	 */
	private static void printResults(int max, int[] ergebnis) 
	{
		System.out.println("Ausgabe der absoluten HÃ¤ufigkeiten als csv, Trenner ist Semikolon.\n");
		
		System.out.println("Augensumme; HÃ¤ufigkeit");
		for (int i=0; i<max; i++) 
		{
			System.out.println(i + " ; " + ergebnis[i]);
		}
	}					  
}
