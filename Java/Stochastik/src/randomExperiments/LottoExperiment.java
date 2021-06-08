import org.apache.commons.math3.random.MersenneTwister;
import org.apache.commons.math3.random.RandomDataGenerator;
import java.util.*;

/**
 * Experiment Münzwurf.
 * 
 * Das Experiment wird zweimal ausgeführt. Einmal mit einer Instanz von
 * Math.Random, und einmal mit einer Instanz eines Mersenne-Twisters
 * aus der Apache Common Math API.
 */
public class LottoExperiment 
{
	public static void main(String[] args) 
	{
		// Zufallsgeneratoren erzeugen
		// Mersenne Twister erzeugen
		MersenneTwister twister = new MersenneTwister();
		// Zufallszahlen-Generator erzeugen mit MersenneTwister-Instanz
		RandomDataGenerator genTwist= new RandomDataGenerator(twister);
		
		Lotto6aus49 simulation = new Lotto6aus49(genTwist);
		
		System.out.println("Simulation von Lotto 6 aus 49");
		draw = simulation.draw();
		
		System.out.println("Die Ziehung:");
		System.out.println(draw);
	}

	static private Vector<Integer> draw;
	


}
