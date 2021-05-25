/**
 * Monte-Carlo Methode zur Bestimmung von Nachkommastellen der irrationalen Zahl pi.
 * 
 * Wir führen das Experiment mit k-Punkten durch,
 * machen das insgesamt n-mal und bilden den Mittelwert.
 */
public class MCPiMeans extends MCPiAbstract 
{
	public static void main(String[] args) {
		
		java.util.Random generator = new java.util.Random();
		
		int k = 10000, n = 10000;
		double hK;
		
		System.out.println("AnnÃ¤herung an pi mit Hilfe einer Monte-Carlo Simulation");		
		System.out.println("Wir beginnnen mit der Simulation!");
		System.out.println("Wir werfen jeweils " + k + "-mal!");
		System.out.println("Wir führen insgesamt " + n + "-mal dieses Experiment durch und berechnen das arithmetische Mittel");
		System.out.println("Sobald die Simulation beendet ist erfolgt wieder eine Ausgabe auf der Konsole!");
		System.out.println("Bitte etwas Geduld!");
		
		int i;
		int[] h = new int[n];
		double[] p = new double[n];
		
		for (i=0; i<n; i++) 
		{
			h[i] = experiment(generator, k);
			hK = (double)h[i]/(double)k;
			p[i] = 4.0*hK;
		}

		// Wir bilden die arithmetische Mittel der relativen HÃ¤ufigkeiten und der SchÃ¤tzungen
		int summehK = 0;
		double summe = 0.0;
		for (i=0; i<n; i++)
		{
			summehK += h[i];
			summe += p[i];
		}
		summe /= (double)n;
		
        printResults(summehK/(double)n, summe);
	}
}
