/**
 * Abstrakte Basisklasse f�r die Experimente mit verschiedenen Zufallszahlengeneratoren
 * und dem zufallsexperiment "Augensumme bei zweimaligem Würfeln".
 */
abstract public class TwoDiesAbstract {
	
	/** Konstruktor */
	public TwoDiesAbstract() {}
	
	/** Funktion für die Simulation eines Würfels.
	 *  
	 *  @return Summe der beiden Würfel
	 */
	abstract public int throwDies();
}
