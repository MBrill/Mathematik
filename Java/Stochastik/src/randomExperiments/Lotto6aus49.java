import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.Well44497a;

/**
 * Simulation Lotto 6 aus 49 mit Hilfe der Commons Math Klassen
 */
public class Lotto6aus49 {
	public static void main(String[] args) {
		// Einen Well-Generator erzeugen
		Well44497a well = new Well44497a();
		// Eine Instanz von RandomDataGenerator mit der Well-Klasse erzeugen
		RandomDataGenerator generator = new RandomDataGenerator(well);
		
		int n=49, m = 6;
		System.out.println("Lotto 6 aus 49 mit Pseudo-Zufallszahlen");
		System.out.println("Zufallszahlengenerator: Well44497a aus der Apache Commons Math");
		
		// Wir ziehen 6 mal und simulieren eine Lotto-Ziehung
		int[] ziehung = new int[6];
		System.out.println("\nUnsere 6 Lottozahlen");
		ziehung = generator.nextPermutation(n, m);
		for (int i=0; i<m; i++) {
			System.out.println((ziehung[i]+1));			
		}
	}
}