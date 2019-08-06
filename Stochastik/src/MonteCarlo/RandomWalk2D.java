import org.apache.commons.math3.random.RandomDataGenerator;

/**
 * Zweidimensionale Brown'sche Molekularbewegung.
 * 
 * "Der Betrunkene in Manhattan"
 * 
 * @author Manfred Brill
 * @version Wintersemester 2019/20
 */
public class RandomWalk2D {
	
	/**
	 * Konstruktor.
	 * 
	 * <p>Falls der Zielpunkt nicht zulässig ist wird
	 * stattdessen der Punkt (xSz, ySz) verwendet!
	 * 
	 * @param gen Zufallszahlengenerator
	 * @param xS x-Koordinate des Startpunkts
	 * @param yS y-Koordinate des Startpunkts
	 * @param xSz Ausdehnung in x-Richtung
	 * @param ySz Ausdehnung in y-Richtung
	 * @param xH x-Koordinate des Zielpunkts
	 * @param yH y-Koordinate des Zielpunkts
	 * @param max Maximale Anzahl der Schritte
	 */
	public RandomWalk2D(RandomDataGenerator gen,
			            int xS, int yS, int xSz, int ySz, 
			            int xH, int yH, int max)
	{
		generator = gen;
		if (inRegion(xH, yH))
		{
			xHome = xH;
			yHome = yH;
		}
		else
		{
			System.err.println("Startpunkt umgesetzt!");
			xHome = xSz;
			yHome = ySz;
		}
		xPosition = xS;
		yPosition = yS;
		maxSteps=max;
	}
	
	/**
	 * Konstruktor.
	 * 
	 * <p>Falls der Zielpunkt nicht zulässig ist wird
	 * stattdessen der Punkt (xSize, ySize) verwendet!
	 * 
	 * @param gen Zufallszahlengenerator
	 * @param xH x-Koordinate des Zielpunkts
	 * @param yH y-Koordinate des Zielpunkts
	 * @param max Maximale Anzahl der Schritte
	 */
	public RandomWalk2D(RandomDataGenerator gen,
			            int xH, int yH, int max)
	{
		generator = gen;
		if (inRegion(xH, yH))
		{
			xHome = xH;
			yHome = yH;
		}
		else
		{
			System.err.println("Startpunkt umgesetzt!");
			xHome = xSize;
			yHome = ySize;
		}
		xPosition = xStart;
		yPosition = yStart;		
		maxSteps=max;
	}
	
	/**
	 * Konstruktor.
	 * 
	 * <p>Falls der Zielpunkt nicht zulässig ist wird
	 * stattdessen der Punkt (xSz, ySz) verwendet!
	 * 
	 * @param gen Zufallszahlengenerator
	 * @param xSz Ausdehnung in x-Richtung
	 * @param ySz Ausdehnung in y-Richtung
	 * @param xH x-Koordinate des Zielpunkts
	 * @param yH y-Koordinate des Zielpunkts
	 * @param max Maximale Anzahl der Schritte
	 */
	public RandomWalk2D(RandomDataGenerator gen,
			            int xSz, int ySz, int xH, int yH, int max)
	{
		generator = gen;
		xSize = xSz;
		ySize = ySz;
		if (inRegion(xH, yH))
		{
			xHome = xH;
			yHome = yH;
		}
		else
		{
			System.err.println("Startpunkt umgesetzt!");
			xHome = xSz;
			yHome = ySz;
		}
		xPosition = xStart;
		yPosition = yStart;		
		maxSteps=max;
	}

	/**
	 * Die Simulation durchführen.
	 * 
	 * Wir haben mehrere Abbruchkriterien.
	 * Einmal, ob wir unser Ziel erreicht haben.
	 * Und dann noch die beiden Abbrüche, wenn wir den Bereich verlassen
	 * oder wenn wir die maximale Anzahl der Iterationen erreicht haben.
	 * 
	 * @return true Das Ziel wurde erreicht
	 *         false Ziel wurde nicht erreicht, die Suche wurde abgebrochen.
	 */
	public boolean walk()
	{
		boolean success = false;
		numberOfSteps = 0;
		do {
			makeAStep();
			numberOfSteps++;
			if (atHome())
			{
				success=true;
				break;
			}
			if (numberOfSteps > maxSteps)
			{
				success=false;
				break;
			}
		} while( !stop );
		
		return success;
	}
	
	/**
	 * Abfragen der x-Koordinate der aktuellen Position.
	 * 
	 * @return x-Koordinate
	 */
	public int getXPosition()
	{
		return xPosition;
	}
	
	/**
	 * Abfragen der y-Koordinate der aktuellen Position.
	 * 
	 * @return y-Koordinate
	 */
	public int getYPosition()
	{
		return yPosition;
	}	
	/**
	 * Überprüfung, ob die aktuelle Position mit dem Ziel übereinstimmt.
	 * 
	 * @return true falls wir das Ziel erreicht haben
	 *        false sonst.
	 */
	/**
	 * Anzahl der durchgeführten Schritte.
	 * 
	 * @return Anzahl
	 */
	public int getNumberOfSteps()
	{
		return numberOfSteps;
	}
	private boolean atHome()
	{
		if ( (xPosition==xHome) && (yPosition==yHome) )
			return true;
		else
			return false;
	}
	/**
	 * Einen Schritt durchführen.
	 * 
	 * <p>Jede der vier Richtungen ist gleich wahrscheinlich. Die
	 * Entscheidung, welche Richtung verwendet wird ist eine zufällige
	 * Entscheidung, die mit Hilfe eines Mersenne Twisters gefällt wird.
	 */
	private void makeAStep()
	{
		int step = 0;
		step = generator.nextInt(1, 4);
		// Je nach Wert der Zufallszahl laufen wir
		// in eine der vier Richtungen.
		switch (step) {
        case 1: 
            xPosition+= stepSize;
            if (xPosition > xSize)
            	stop = true;
            break;
        case 2:
        	yPosition+= stepSize;
            if (yPosition > ySize)
            	stop = true;
        	break;
        case 3:
        	xPosition-= stepSize;
            if (xPosition < -xSize)
            	stop = true;
        	break;
        case 4:
        	yPosition-= stepSize;
            if (yPosition < -ySize)
            	stop = true;
            break; 
        default:
        	System.err.println("Bei der Bestimmung der Richtung ist ein unerwarteter Fehler aufgetreten!");
        	break;
		}
	}
	/**
	 * Überprüfen, ob eine Position innerhalb des Bereichs liegt.
	 * 
	 * @return true Position ist ok		
	 */
	private boolean inRegion(int x, int y)
	{
		boolean ok = true;
		if ( (x < -xSize) || (x > xSize))
			ok = false;
		if ( (y < -ySize) || (y > ySize))
			ok = false;
		return ok;
	}
	/**
	 * Ausdehnung des Bereichs in x-Richtung.
	 * 
	 * Die x-Koordinaten sind durch -xSize, ..., 0, ..., xSize gegeben.
	 */
	private int xSize = 10;
	/**
	 * Ausdehnung des Bereichs in y-Richtung
	 * 
	 * Die y-Koordinaten sind durch -ySize, ..., 0, ..., ySize gegeben.
	 */
	private int ySize = 10;
	/**
	 * Die x-Koordinate des Startpunkts.
	 */	
	private int xStart = 0;
	/**
	 * Die y-Koordinate des Startpunkts
	 */	
	private int yStart = 0;
	/**
	 * Die x-Koordinate des Zielpunkts.
	 */	
	private int xHome = 5;
	/**
	 * Die y-Koordinate des Zielpunkts
	 */	
	private int yHome = 3;
	/**
	 * Die x-Koordinate der aktuellen Position.
	 */
	private int xPosition= 0;
	/**
	 * Die x-Koordinate der aktuellen Position.
	 */
	private int yPosition = 0;	
	/**
	 * Maximale Anzahl von Schritten.
	 * 
	 * <p>Wird diese Anzahl von Schritten größer als eine vorgegebene
	 * Schranke, dann beenden wir unsere Iteration.
	 */
	private int maxSteps = 100;
	/**
	 * Anzahl der Iterationen.
	 * 
	 * <p>Auf dieser Variablen finden wir die Anzahl der durchgeführten
	 * Bewegungen.
	 */
	private int numberOfSteps = 0;
	/**
	 * Schrittweite.
	 * 
	 * <p>Die Schrittweite ist immer 1. Diese Variable könnten wir später
	 * auch mit einem Zufallszahlengenerator verändern.
	 */
	private int stepSize = 1;
	/**
	 * Wir verlassen den Bereich oder haben zu lange gesucht.
	 * 
	 * <p>Ist diese Variable true, dann beenden wir die Simulation. 
	 * Wir haben den Bereich verlassen oder die maximale Anzahl der Schritte
	 * wurde erreicht.
	 */
	private boolean stop = false;
	/** 
	 * Instanz des Zufallszahlen-Generators.
	 * 
	 * <p>Der Zufallszahlengenerator wird im Hauptprogram erzeugt und
	 * den Konstruktoren übergeben.
	 */
	private RandomDataGenerator generator;	
	 
}
