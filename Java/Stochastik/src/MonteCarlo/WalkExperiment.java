import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.MersenneTwister;


/**
 * Experiment RandomWalk.
 * 
 * @author Manfred Brill
 * @version Wintersemester 2019/20
 */
public class WalkExperiment 
{
	public static void main(String[] args) 
	{
		// Zufallsgeneratoren erzeugen
		MersenneTwister twister = new MersenneTwister();
		// Zufallszahlen-Generator erzeugen mit MersenneTwister-Instanz
		RandomDataGenerator genTwist= new RandomDataGenerator(twister);
		int max = 100,
			xStart = 0,
			yStart = 0,
			xH = -3,
		    yH = 3,
		    xSize = 5,
			ySize = 5;
		// RandomWalk
        RandomWalk2D experiment = new RandomWalk2D(genTwist, 
        		                                   xStart, yStart,
        		                                   xSize, ySize, 
        		                                   xH, yH, 
        		                                   max);
        		       
        // Wir führen das Experiment durch
		int numberOfRuns = 10000000, N=100;
		double counter = 0.0, means = 0.0;
		
		System.out.println("Wir simulieren den Random Walk");
		System.out.println("Der Zielpunkt ist (" + xH + "," + yH + ")");
		System.out.println("Wir führen das Experiment " + N + "-mal durch.");
		System.out.println("Jedes Experiment testet den Zielpunkt " + numberOfRuns + "-mal");
		System.out.println("Bitte etwas Geduld!");
		
		for (int i=0; i<N; i++)
		{
			counter = 0.0;
			for (int j=0; j<numberOfRuns; j++) 
			{
			if (experiment.walk())
				counter += 1.0;
			}
			means += counter/numberOfRuns;
		}
		
		// Mittelwertsregel anwenden
		means /= N;
		
		System.out.println("\nDas Experiment ist beendet!");
		System.out.println("Die Wahrscheinlichkeit, dass wir unser Ziel erreichen ist " + 
		                    means);
		
	}

}
