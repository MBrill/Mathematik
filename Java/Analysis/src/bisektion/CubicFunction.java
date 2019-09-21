/**
 * Implementierung einer kubischen Parabel als Beispiel einer Funktion
 * in der Nullstellensuche.
 * 
 * @author $Author$
 * @version $Revision$
 */
package analysis.bisektion;

import analysis.Function;


public class CubicFunction implements Function {
	@Override	
    public double call(double x) {
    	return x*x*x - 8.0;
    }
    
}
