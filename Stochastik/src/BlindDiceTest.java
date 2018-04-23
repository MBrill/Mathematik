import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.MersenneTwister;

/**
 * Experiment mit sechs blinden Würfeln.
 * 
 * Wir überprüfen, ob die Binomialverteilung beim Erzeugen
 * der zwei Seiten mit Wahrscheinlichkeit p passt.
 */
public class BlindDiceTest 
{
	public static void main(String[] args) 
	{
		// Mersenne Twister erzeugen
		MersenneTwister twister = new MersenneTwister();
		// Zufallszahlen-Generator erzeugen mit MersenneTwister-Instanz
		RandomDataGenerator genTwist= new RandomDataGenerator(twister);
		
		// Die sechs blinden Würfel erzeugen
	    BlindDice one = new BlindDice(1, genTwist);	

	
		// Wie oft möchten wir würfeln?
		final int n=6000;
		// Variable für die Durchführung
		int value=0, i;
		// Erwartungswert, der eintreten sollte
		double erwartung = n * one.getP();
		
		System.out.println("Wir simulieren " + n + " Würfe mit einem blinden Würfel!");
		// Würfeln mit dem linearen Kongruenz-Generator
		for (i=0; i<n; i++) 
		{
			value += one.throwDice();
		}
			
		
		// Die Ergebnisse ausgeben
		System.out.println("Ergebnisse für den Test des blinden Würfels");
		System.out.println("-----------------------------------");		
		System.out.println("Der Erwartungswert für den verwendeten Würfel ist " + erwartung);
		System.out.println("Die Summe der Augen zum Vergleich ist " + value);
	}
	
			  
}
