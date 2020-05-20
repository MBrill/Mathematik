/**
 * Abstrakte Basisklasse f�r die Experimente mit verschiedenen Zufallszahlengeneratoren
 * und dem zufallsexperiment "Werfen einer fairen M�nze".
 */
abstract public class ThrowCoinAbstract {
	
	/** Konstruktor */
	public ThrowCoinAbstract() {}
	
	/** Funktion für die Simulation eines Würfels.
	 *  
	 *  @return Summe der beiden Würfel
	 */
	abstract public int throwCoin();
}
