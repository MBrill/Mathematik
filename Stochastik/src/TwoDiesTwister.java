import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.MersenneTwister;

/**
 * Realisierung eines Zufallsexperiments zweimal würfeln und Augensumme
 * mit einer Instanz eines Mersenne Twisters aus der Apache Commons Math API.
 */
public class TwoDiesTwister extends TwoDiesAbstract {
	/** 
	 * Konstruktor 
	 */
	public TwoDiesTwister() {	
		// Mersenne Twister erzeugen
		MersenneTwister twister = new MersenneTwister();
		// Zufallszahlen-Generator erzeugen mit MersenneTwister-Instanz
		generator = new RandomDataGenerator(twister);
	}
	
	/** 
	 * @see TwoDiesAbstract#throwDies()
	 */
	@Override
	public int throwDies() {
		return generator.nextInt(1, 6) + generator.nextInt(1, 6);
	}

	/** 
	 * Instanz des Generators 
	 */
	private RandomDataGenerator generator;	
}
