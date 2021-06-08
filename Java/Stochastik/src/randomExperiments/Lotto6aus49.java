import org.apache.commons.math3.random.RandomDataGenerator;
import java.util.*;

/**
 * Simulation einer Lotto-Ziehung für Lotto 6 aus 49.
 */
public class Lotto6aus49 
{
	/** 
	 * Default-Konstruktor ohne Zufallszahlengenerator
	 */
	public Lotto6aus49() 
	{	
		m = 49;
		n = 6;
	}
	
	/** 
	 * Konstruktor mit einer Instanz eines Zufallszahlen-Generators
	 */
	public Lotto6aus49(RandomDataGenerator gen) 
	{	
		m = 49;
		n = 6;
		generator = gen;
	}
	
	/** 
	 * Die Ziehung durchführen
	 * 	  
	 * @return Wappen (=0) oder Zahl (=1)
	 */
	public Vector<Integer> draw() 
	{
		int[] ziehung = new int[n];
		ziehung = generator.nextPermutation(m, n);
		Vector<Integer> draw = new Vector<Integer>(6);
		for (int i = 0; i < n; i++)
			draw.add(ziehung[i]+1);
		return draw;
	}
	
	/** 
	 * Instanz des Generators 
	 */
	private RandomDataGenerator generator;	
	/**
	 * Wie viele Kugeln haben wir in der Trommel?
	 */
	int m;
	/**
	 * Wie viele Kugeln ziehen wir?
	 */
	int n;
}
