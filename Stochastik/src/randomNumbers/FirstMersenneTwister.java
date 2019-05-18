import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.MersenneTwister;

/**
 * Erstes Beispiel für den Einsatz einer Instanz eines Mersenne-Twisters aus
 * der Apache Commons Math.
 */
public class FirstMersenneTwister {

	public static void main(String[] args) {
		// Mersenne Twister erzeugen
		MersenneTwister twister = new MersenneTwister();
		// Zufallszahlen-Generator erzeugen mit MersenneTwister-Instanz
		RandomDataGenerator generator = new RandomDataGenerator(twister);
		
		System.out.println("Zufallszahlen mit dem Mersenne Twister in RandomDataGenerator");
		System.out.println("-------------------------------------------------------------");
		// Eine Zufallszahl ...
		double val = generator.nextUniform(0.0,  1.0);
		System.out.println("Eine Zufallszahl im Einheitsintervall " + val);
		
		// 10 zufÃ¤llige WÃ¼rfelergebnisse ...
		System.out.println("Wir erzeugen 10 zufällige Würfelergebnisse!");		
		for (int i=0; i<10; i++) {
			System.out.print(generator.nextInt(1, 6) + " ");
		}
	}
}
