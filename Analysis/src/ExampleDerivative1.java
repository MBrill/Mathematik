package analysis;

import analysis.Function;

/**
 * Implementierung der Ableitung der Funktion x + e^x - 1 für die Beispiele
 * in der Nullstellensuche. 
 * 
 * <P>Wird beim Test des Newton-Verfahrens verwendet.</p>
 * 
 * @see analysis.ExampleFunction1
 * @see analysis.Function
 * 
 * <p>Letzte Änderung: $Date: 2014/07/23 $
 * 
 * @author $Author: brill $
 * @version $Revision: #2 $
 */
public class ExampleDerivative1 implements Function {

	@Override
	public double call(double x) {
		return 1.0 + Math.exp(x);
	}

}
