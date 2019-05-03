import java.util.Random;

/**
 * Realisierung des Zufallsexperiments "Werfen einer fairen Münze"
 * mit einer Instanz von Math.Random.
 */
public class ThrowCoinRandom extends ThrowCoinAbstract {
	/** 
	 * Konstruktor 
	 */
	public ThrowCoinRandom(Random gen) 
	{	
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
			boolean result = generator.nextBoolean();
			if (result) 
				return 1;
			else 
				return 0;		
	}

	/** 
	 * Instanz des Generators 
	 */
	private Random generator;	
}
