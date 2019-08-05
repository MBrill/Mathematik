import org.apache.commons.math3.random.RandomDataGenerator;

/**
 * Zweidimensionale Brown'sche Molekularbewegung.
 * 
 * "Der Betrunkene in Manhattan"
 */
public class RandomWalk2D {
	
	/**
	 * Konstruktor.
	 * 
	 * @param Zufallszahlengenerator
	 * @param xS x-Koordinate des Startpunkts
	 * @param yS y-Koordinate des Startpunkts
	 * @param xSz Ausdehung in x-Richtung
	 * @param ySz Ausdehung in y-Richtung
	 * @apram xH x-Koordinate des Zielpunkts
	 * @param yH y-Koordinate des Zielpunkts
	 * @param max Maximale Anzahl der Schritte
	 */
	public RandomWalk2D(RandomDataGenerator gen,
			int xS, int yS, int xSz, int ySz, int xH, int yH, int max)
	{
		generator = gen;
		xHome = xH;
		yHome = yH;
		xStart = 0;
		yStart = 0;
		maxSteps=max;
	}
	
	/**
	 * Konstruktor.
	 * 
	 * @param Zufallszahlengenerator
	 * @apram xH x-Koordinate des Zielpunkts
	 * @param yH y-Koordinate des Zielpunkts
	 * @param max Maximale Anzahl der Schritte
	 */
	public RandomWalk2D(RandomDataGenerator gen,
			int xH, int yH, int max)
	{
		generator = gen;
		xHome = xH;
		yHome = yH;
		xStart = 0;
		yStart = 0;
		maxSteps=max;
	}
	
	/**
	 * Konstruktor.
	 * 
	 * @param Zufallszahlengenerator
	 * @param xS x-Koordinate des Startpunkts
	 * @param yS y-Koordinate des Startpunkts
	 * @apram xH x-Koordinate des Zielpunkts
	 * @param yH y-Koordinate des Zielpunkts
	 * @param max Maximale Anzahl der Schritte
	 */
	public RandomWalk2D(RandomDataGenerator gen,
			int xS, int yS, int xH, int yH, int max)
	{
		generator = gen;
		xSize = xS;
		ySize = yS;
		xHome = xH;
		yHome = yH;
		xStart = 0;
		yStart = 0;
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
	 * Nur wenn das Ziel erreicht ist geben wir reached = TRUE zurück .....
	 */
	public boolean walk()
	{
		boolean success = false;
		numberOfSteps = 0;
		do {
			makeAStep();
			success = stop || atHome();
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
	 * Überprüfung, ob die aktuelle Position mit dem  Ziel übereinstimmt.
	 * 
	 * @return true falls wir das Ziel erreicht haben
	 *        false sonst.
	 */
	public boolean atHome()
	{
		if ( (xPosition==xHome) && (yPosition==yHome) )
			return true;
		else
			return false;
	}
	/**
	 * Einen Schritt durchführen.
	 * 
	 * Jede der vier Richtungen ist gleich wahrscheinlich. Die
	 * Entscheidung, welche Richtung verwendet wird ist eine zufällige
	 * Entscheidung, die mit Hilfe eines Mersenne Twisters gefällt wird.
	 */
	public void makeAStep()
	{
		int step = 0;
		step = generator.nextInt(1, 4);
		// Je nach Wert der Zufallszahl laufen wir
		// in eine der vier Richtungen.
		switch (step) {
        case 1: 
            xPosition++;
            if (xPosition > xSize)
            	stop = true;
            break;
        case 2:
        	yPosition++;
            if (yPosition > ySize)
            	stop = true;
        	break;
        case 3:
        	xPosition--;
            if (xPosition < -xSize)
            	stop = true;
        	break;
        case 4:
        	yPosition--;
            if (yPosition < -ySize)
            	stop = true;
            break; 
        default:
        	break;
		}
		
		numberOfSteps++;
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
	private static int xStart = 0;
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
	 * Wird diese Anzahl von Schritten größer als eine vorgegebene
	 * Schranke, dann beenden wir unsere Iteration.
	 */
	private int maxSteps = 100;
	/**
	 * Anzahl der Iterationen.
	 * 
	 * Auf dieser Variablen finden wir die Anzahl der durchgeführten
	 * Bewegungen.
	 */
	private int numberOfSteps = 0;
	/**
	 * Schrittweite.
	 * 
	 * Die Schrittweite ist immer 1. Diese Variable könnten wir später
	 * auch mit einem Zufallszahlengenerator verändern.
	 */
	private int stepSize = 1;
	/**
	 * Abbruch
	 * 
	 * Ist diese Variable true, dann beenden wir die Simulation. Das kann einmal 
	 * bedeuten, dass wir die gesuchte Heimatposition erreicht haben,
	 * dass wir den Bereich verlassen haben oder dass die maximale Anzahl der Schritte
	 * erreicht wurde.
	 */
	private boolean stop = false;
	/** 
	 * Instanz des Zufallszahlen-Generators.
	 * 
	 * Der Zufallszahlengenerator wird im Hauptprogram erzeugt und
	 * den Konstruktoren übergeben.
	 */
	private RandomDataGenerator generator;	
	 
}
