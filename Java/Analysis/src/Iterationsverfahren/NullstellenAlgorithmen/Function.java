/**
 * Interface für die Funktionen, die wir bei den Nullstellenalgorithmen einsetzen.
 * Ein konkretes Beispiel kann dann als Klass implementiert werden, die dieses
 * Interface implementiert.
 * 
 * @author $Author: brill $
 * @version $Revision: #2 $ 
 */
package Iterationsverfahren.NullstellenAlgorithmen;

public interface Function {

	/** 
	 * Interface für Funktionen in den Nullstellenalgorithmen.
	 * 
	 * Wir rufen die Funktion mit call(). 
	 * Der Rückgabewert ist double; das Argument ist ebenfalls eine double-Zahl. 
	 */
	public double call(double x);
}
