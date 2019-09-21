import org.apache.commons.math3.random.RandomDataGenerator;

/**
 * Realisierung des Zufallsexperiments "zweimal würfeln und Augensumme bilden"
 * mit einer Instanz eines Mersenne Twisters aus der Apache Commons Math API.
 */
public class TwoDiesTwister extends TwoDiesAbstract {
	/** 
	 * Konstruktor 
	 */
	public TwoDiesTwister(RandomDataGenerator gen) {	
		// Zufallszahlen-Generator erzeugen mit MersenneTwister-Instanz
		generator = gen;
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
