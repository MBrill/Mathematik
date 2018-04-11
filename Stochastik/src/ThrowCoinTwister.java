import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.MersenneTwister;

/**
 * Realisierung des Zufallsexperiments "Werfen einer fairen Münze"
 * mit einer Instanz eines Mersenne Twisters aus der Apache Commons Math API.
 */
public class ThrowCoinTwister extends ThrowCoinAbstract {
	/** 
	 * Konstruktor 
	 */
	public ThrowCoinTwister() 
	{	
		// Mersenne Twister erzeugen
		MersenneTwister twister = new MersenneTwister();
		// Zufallszahlen-Generator erzeugen mit MersenneTwister-Instanz
		generator = new RandomDataGenerator(twister);
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
