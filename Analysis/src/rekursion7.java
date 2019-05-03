/**
 * @author Manfred Brill
 * Java-Source-Code zur Aufgabe rekursion7.tex
 * Näherung durch Vorwärts- und Rückwärts-Iteration
 * und Illustration des Einflusses von Rundungsfehlern
 * bei solchen Berechnungen.
 */
public class rekursion7 
{

	public static void main(String[] args) 
	{
	    int startN = 50, N = 30;	
		double startValue = 100000.0;
		
		// Durchführen der Vorwärts-Iteration
		forwardIteration(N);
		
		System.out.println("\n\n");
		
		// Jetzt die Rückwärts-Iteration
		backwardIteration(startN, N, startValue);	
	}
	
    /*!
     * @arg n : Anzahl der durchgeführten Iteration
     * @return: Berechneter Wert
     */
    static private void forwardIteration(int n)
    {
          // Zähler für die Rekursion
    	  int counter;
          // Der Startwert
          double iterationValue = (Math.exp(1.0)-1.0)/Math.exp(1.0);

          System.out.println("Vorwärts-Iteration mit Startwert " + iterationValue);
          System.out.println("");
          
          for (counter = 1; counter <= n; counter++)
          {
                iterationValue = 1.0 - counter*iterationValue;
                System.out.println("k = " + counter + ": "+iterationValue);
          }
         
      }

      /*!
       * @arg start      Index, an dem die Iteration starten soll (in der Aufgabe 50)
       * @arg n          Index, an dem die Iteration angehalten werden soll (in der Aufgabe 30)
       * @arg startValue Startwert am Index start
       * @return         Ergebnis der Iteration
       */
      static private void backwardIteration(int start, int n, double startValue)
      {
          // Zähler
    	  int counter;
          // Variable für den Wert der Rekursion
    	  double iterationValue;

          iterationValue = startValue;
          System.out.println("Rückwärts-Iteration mit Startwert " + iterationValue);
          System.out.println("Die Iteration startet am Index " + start);
          System.out.println("");      
          
          for (counter = start-1; counter >= n; counter--)
          {
        	  iterationValue = (1.0-iterationValue)/(double)(counter);
              System.out.println("k = " + counter + ": "+iterationValue);
          }
        	 
      } 
}
