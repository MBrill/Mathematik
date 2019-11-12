package Iterationsverfahren.NullstellenAlgorithmen;

import Iterationsverfahren.NullstellenAlgorithmen.Function;

/** Beispielfunktion für Regula Falsi und Newton-Verfahren
 * 
 * Implementierung der Funktion x + e^x - 1 für die Beispiele
 * in der Nullstellensuche .
 */
public class ExampleFunction1 implements Function {

	@Override
	public double call(double x) {
		return x + Math.exp(x) - 1.0;
	}

}
