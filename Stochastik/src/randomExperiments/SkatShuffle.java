import org.apache.commons.math3.random.RandomDataGenerator;

/**
 * Simulation Mischen eines Skatblatts mit Hilfe der Commons Math API
 */
public class SkatShuffle {
	public static void main(String[] args) {
		int i, n = 32;
		int[] skatBlatt = new int[n];

		RandomDataGenerator generator = new RandomDataGenerator();

		skatBlatt = generator.nextPermutation(n, n);
		System.out.println("Das Ergebnis");
		for (i=0; i<n; i++) {
			System.out.println("Die " + i + " Karte ist  "  + skatBlatt[i]);
		}

	}

}
