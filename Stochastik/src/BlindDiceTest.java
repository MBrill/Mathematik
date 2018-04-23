import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.MersenneTwister;

/**
 * Experiment mit sechs blinden W�rfeln.
 * 
 * Wir �berpr�fen, ob die Binomialverteilung beim Erzeugen
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
		
		// Die sechs blinden W�rfel erzeugen
	    BlindDice one = new BlindDice(1, genTwist);	

	
		// Wie oft m�chten wir w�rfeln?
		final int n=6000;
		// Variable f�r die Durchf�hrung
		int value=0, i;
		// Erwartungswert, der eintreten sollte
		double erwartung = n * one.getP();
		
		System.out.println("Wir simulieren " + n + " W�rfe mit einem blinden W�rfel!");
		// W�rfeln mit dem linearen Kongruenz-Generator
		for (i=0; i<n; i++) 
		{
			value += one.throwDice();
		}
			
		
		// Die Ergebnisse ausgeben
		System.out.println("Ergebnisse f�r den Test des blinden W�rfels");
		System.out.println("-----------------------------------");		
		System.out.println("Der Erwartungswert f�r den verwendeten W�rfel ist " + erwartung);
		System.out.println("Die Summe der Augen zum Vergleich ist " + value);
	}
	
			  
}
