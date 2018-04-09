import org.apache.commons.math3.random.RandomDataGenerator;

/**
 * Erste Verwendung der Zufallszahlen-Generatoren aus der Apache Commons Math Bibliothek
 */
public class FirstApacheRandom {

	public static void main(String[] args) {
		// RandomDataGenerator mit dem Default-Generator erzeugen
		RandomDataGenerator generator = new RandomDataGenerator();
		int i, d;
		
		System.out.println("Zufallszahlen mit Apache RandomDataGenerator");
		System.out.println("--------------------------------------------");
		
		// Eine Zufallszahl zwischen 0.0 und 1.0 als double-Zahl
		double val = generator.nextUniform(0.0,  1.0);
		System.out.println("Eine Zufallszahl im Einheitsintervall " + val);
		
		// 10 zufÃ¤llige WÃ¼rfelergebnisse ...
		System.out.println("Wir erzeugen 10 zufällige Würfel-Ergebnisse!");
		for (i=0; i<10; i++) {
			d = generator.nextInt(1, 6);
			System.out.print(d + " ");
		}
	}
}
