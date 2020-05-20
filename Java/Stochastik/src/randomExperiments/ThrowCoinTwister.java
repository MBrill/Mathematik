import org.apache.commons.math3.random.RandomDataGenerator;

/**
 * Realisierung des Zufallsexperiments "Werfen einer fairen Münze"
 * mit einer Instanz eines Mersenne Twisters aus der Apache Commons Math API.
 */
public class ThrowCoinTwister extends ThrowCoinAbstract {
	/** 
	 * Konstruktor 
	 */
	public ThrowCoinTwister(RandomDataGenerator gen) 
	{	
		// Zufallszahlen-Generator
		generator = gen;
	}
	
	/** 
	 * @see ThrowCoinAbstract#throwCoin()
	 * 	  
	 * @return Wappen (=0) oder Zahl (=1)
	 */
	@Override
	public int throwCoin() 
	{
		return generator.nextBinomial(1, 0.5);
	}

	/** 
	 * Instanz des Generators 
	 */
	private RandomDataGenerator generator;	
}
