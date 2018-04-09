import java.util.Random;
import org.apache.commons.math3.random.RandomDataGenerator;

/**
 * M�nzwurf mit java.util.Random und Ausgabe der Statistik
 * 
 * Aufgabe 1.5
 */
public class CoinExperiment {
	public static void main(String[] args) {
		int i;
        // Zufallszahlen-Generator instanziieren
		Random generator = new java.util.Random();
		
		// Daten f�r das Experiment
		final int N=100;
		int countWappen = 0, 
			countZahl = 0;
		
		for (i=0; i<N; i++) {
			boolean result = generator.nextBoolean();
			if (result) {
				System.out.println("Wappen");
				countWappen++;
			}
			else {
				System.out.println("Zahl");
				countZahl++;
			}
		}
		
		// Statistik ausgeben
		System.out.println("Ergebnisse f�r java.util.Random");
		System.out.println("Es wurde " + countWappen + " Wappen geworfen!");
		System.out.println("Es wurde " + countZahl + " Zahl geworfen!");
		System.out.println("Relative H�ufigkeiten");
		System.out.println("Die relative H�ufigkeit f�r Wappen ist " + (float)(countWappen)/N);
		System.out.println("Die relative H�ufigkeit f�r Zahl ist " + (float)(countZahl)/N);
		
		RandomDataGenerator generatorApache= new RandomDataGenerator();		
		// Mit WELL-Generator
		countWappen = 0;
		countZahl   = 0;
		for (i=0; i<N; i++) {
			int result = generatorApache.nextBinomial(1, 0.5);
			if (result==0) {
				System.out.println("Wappen");
				countWappen++;
			}
			else {
				System.out.println("Zahl");
				countZahl++;
			}
		}
		// Statistik ausgeben
		System.out.println("Ergebnisse f�r commons.math.RandomGenerator");
		System.out.println("Es wurde " + countWappen + " Wappen geworfen!");
		System.out.println("Es wurde " + countZahl + " Zahl geworfen!");
		System.out.println("Relative H�ufigkeiten");
		System.out.println("Die relative H�ufigkeit f�r Wappen ist " + (float)(countWappen)/N);
		System.out.println("Die relative H�ufigkeit f�r Zahl ist " + (float)(countZahl)/N);		
	}

}
