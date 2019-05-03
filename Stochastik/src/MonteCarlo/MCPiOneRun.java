/**
 * Monte-Carlo Methode zur Bestimmung von pi
 * 
 * Wir verwenden einen gro�en Wert f�r n und f�hren
 * das Monte-Carlo Experiment damit aus.
 */
public class MCPiOneRun extends MCPiAbstract 
{
	public static void main(String[] args) {
		
		java.util.Random generator = new java.util.Random();
		
		int k = 100000000;
		double hK, p;
		
		System.out.println("Ann�herung an pi mit Hilfe einer Monte-Carlo Simulation");		
		System.out.println("Wir beginnnen mit der Simulation!");
		System.out.println("Wir werfen " + k + "-mal!");
		System.out.println("Sobald die Simulation beendet ist erfolgt wieder eine Ausgabe auf der Konsole!");
		System.out.println("Bitte etwas Geduld!");
		
		int h = experiment(generator, k);

		hK = (double)h/(double)k;
		p = 4.0 * hK;
        printResults(hK, p);
	}
}
