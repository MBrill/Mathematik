package Iterationsverfahren.NullstellenAlgorithmen;

import Iterationsverfahren.NullstellenAlgorithmen.Function;
/**
 * Implementierung der Ableitung der Funktion x + e^x - 1 für die Beispiele
 * in der Nullstellensuche. 
 * 
 * <P>Wird beim Test des Newton-Verfahrens verwendet.</p>
 * 
 * @see Iterationsverfahren.NullstellenAlgorithmen.ExampleFunction1
 * @see Iterationsverfahren.NullstellenAlgorithmen.Function
 */
public class ExampleDerivative1 implements Function {

	@Override
	public double call(double x) {
		return 1.0 + Math.exp(x);
	}

}
