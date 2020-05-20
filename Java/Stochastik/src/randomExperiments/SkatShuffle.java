import org.apache.commons.math3.random.RandomDataGenerator;

/**
 * Simulation Mischen eines Skatblatts mit Hilfe der Commons Math API.
 * 
 * Wir geben als Ergebnis Zahlen zwischen 1 und 32 aus. Dabei gehen wir davon
 * aus, dass die erste 8 Karten zu Karo gehören und so weiter, in der 
 * Reihenfolge 7 - 8 - 9 - 10 - Bube - Dame - König - Ass.
 */
public class SkatShuffle {
	public static void main(String[] args) {
		int i, n = 32;
		int[] skatBlatt = new int[n];

		RandomDataGenerator generator = new RandomDataGenerator();

		skatBlatt = generator.nextPermutation(n, n);
		System.out.println("Das Ergebnis");
		for (i=0; i<n; i++) {
			System.out.println("Die " + (i+1) + ". Karte ist  "  + skatBlatt[i]);
		}

	}

}
