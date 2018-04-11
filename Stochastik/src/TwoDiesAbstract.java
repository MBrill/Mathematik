/**
 * Abstrakte Basisklasse f�r die Experimente mit verschiedenen Zufallszahlengeneratoren
 * und dem zufallsexperiment "Augensumme bei zweimaligem W�rfeln".
 */
abstract public class TwoDiesAbstract {
	
	/** Konstruktor */
	public TwoDiesAbstract() {}
	
	/** Funktion f�r die Simulation eines W�rfels.
	 *  
	 *  @return Summe der beiden W�rfel
	 */
	abstract public int throwDies();
}
