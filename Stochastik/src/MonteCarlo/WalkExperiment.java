import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.MersenneTwister;


/**
 * Experiment RandomWalk.
 */
public class WalkExperiment 
{
	public static void main(String[] args) 
	{
		int max = 20;
		int xH = 2;
		int yH = 1;
		// Zufallsgeneratoren erzeugen
		MersenneTwister twister = new MersenneTwister();
		// Zufallszahlen-Generator erzeugen mit MersenneTwister-Instanz
		RandomDataGenerator genTwist= new RandomDataGenerator(twister);
		// Erster RandomWalk mit Home (5,3) und 10 Iterationen
        RandomWalk2D experiment = new RandomWalk2D(genTwist, xH, yH, max);
        		
        
		int i;
		boolean reached = false;
		System.out.println("Wir simulieren den Random Walk");
		for (i=0; i<max; i++) 
		{
			experiment.makeAStep();
			//System.out.println("Die Position: ( " + experiment.getXPosition() + 
					//" , " + experiment.getYPosition() + " )");
			if (experiment.atHome()) {
				reached = true;
				break;
			}
		}
		
		if (reached)
			System.out.println("Wir haben unser Ziel erreicht!");
		else
			System.out.println("into the blue!");
	}

}
