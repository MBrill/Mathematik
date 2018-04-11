/**
 * Experiment M�nzwurf.
 * 
 * Das Experiment wird zweimal ausgef�hrt. Einmal mit einer Instanz von
 * Math.Random, und einmal mit einer Instanz eines MersenneTwisters
 * aus der Apache Common Math API.
 */
public class CoinExperiment 
{
	public static void main(String[] args) {

        ThrowCoinRandom  experiment1 = new ThrowCoinRandom();
        ThrowCoinTwister experiment2 = new ThrowCoinTwister();
        
		int i, ergebnis;
		// Wir oft wollen wir jeweils eine M�nze werfen?
		final int n=100000;
		
		System.out.println("Wir simulieren M�nzw�rfe mit Math.Random!");
		for (i=0; i<n; i++) 
			counter(experiment1.throwCoin());
		
		// Statistik ausgeben
		System.out.println("\n");		
		System.out.println("Ergebnisse f�r Math.Random");
		System.out.println("-----------------------------------");
		printResults(n);

		// Counter zur�cksetzen f�r das zweite Experiment
		countWappen=0;
		countZahl=0;
		
		System.out.println("\n");
		System.out.println("Wir simulieren M�nzw�rfe mit dem Mersenne-Twister!");
		for (i=0; i<n; i++) 
			counter(experiment2.throwCoin());
		
		// Statistik ausgeben
		System.out.println("\n");
		System.out.println("Ergebnisse f�r den Mersenne-Twister");
		System.out.println("-----------------------------------");
		printResults(n);
	}

	/** Variable f�r die absolute H�ufigkeit f�r Wappen */
	private static int countWappen=0;
	/** Variable f�r die absolute H�ufigkeit f�r Wappen */	
	private static int countZahl=0;
	
	/**
	 * Erfassen der Ergebnisse auf zwei Variablen
	 * 
	 * Die Funktion z�hlt die beiden Counter hoch. Es wird
	 * *nicht* �berpr�ft, ob ergebnis nicht 0 ode 1 ist!
	 * Alle Eingaben ungleich 0 werden als Zahl interpretiert!
	 * 
	 * @param ergebnis Wappen (=0) oder Zahl (=1)?
	 */
	private static void counter(int ergebnis)
	{
		if (ergebnis==0)
			countWappen++;
		else
			countZahl++;
	}
	
	/**
	 * Ausgabe der absoluten H�ufigkeiten als csv-Liste, mit Trenner Semikolon.
	 * 
	 * Die erste ausgegebene absolute H�ufigkeit ist die Anzahl der Wappen, die zweite die Anzahl f�r Zahl.
	 * 
	 * @param n Anzahl der Experimente f�r die Berechnung der relativen H�ufigkeiten
	 */
	private static void printResults(int n) 
	{	
		System.out.println("Es wurden " + n + " Simulationen durchgef�hrt!");
		System.out.println("Ausgabe der absoluten H�ufigkeiten Wappen/Zahl als csv, Semikolon ist der Trenner.");
		System.out.println(countWappen + ";" + countZahl);
		System.out.println("Ausgabe der relativen H�ufigkeiten Wappen/Zahl als csv, Semikolon ist der Trenner.");
		System.out.println((double)countWappen/n + ";" + (double)countZahl/n);
		System.out.println("Abweichungen Wappen/Zahl von der theoretischen relativen H�ufigkeit 0.5 als csv, Semikolon ist der Trenner.");
		System.out.println(Math.abs((double)countWappen/n-0.5) + ";" + Math.abs((double)countZahl/n-0.5));		
		
	}

}
