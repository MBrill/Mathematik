package analysis;

import analysis.Function;

/**
 * Implementierung der Funktion x + e^x - 1 für die Beispiele
 * in der Nullstellensuche (Regula Falsi und Newton-Verfahren verwenden
 * diese Funktion).
 * 
 * @author $Author$
 * @version $Revision$
 */
public class ExampleFunction1 implements Function {

	@Override
	public double call(double x) {
		return x + Math.exp(x) - 1.0;
	}

}
