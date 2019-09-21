import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.Well44497a;

/**
 * Monte-Carlo Simulation für die Bestimmung der Euler'schen Zahl
 * 
 * <p>Wir führen das Rencontre-Problem mit einer Anzahl n von
 * Karten durch und z�hlen in einer Anzahl von Durchl�ufen, wie
 * häufig die Bank gewinnt - wie häufig also ein Rencontre stattfindet.
 * 
 * <p>Man weiß, dass die Wahrscheinlichkeit f_n für ein Rencontre für
 * n gegen Unendlich gegen 1 - 1/e konvergiert. Wir verwenden unsere berechneten
 * relativen Häufigkeiten als Näherung f�r f_n und lösen die dadurch
 * entstehende Gleichung nach e auf. Dann erhalten wir eine Monte-Carlo
 * N�herung für die Euler'sche Zahl als
 *      e = 1/(1-f_n).
 */
public class MCEuler {
	public static void main(String[] args) {
		
		// Einen Well-Generator erzeugen
		Well44497a well = new Well44497a();
		// Eine Instanz von RandomDataGenerator mit der Well-Klasse erzeugen
		RandomDataGenerator generator = new RandomDataGenerator(well);
		
		System.out.println("Monte-Carlo Simulation f�r die Euler'sche Zahl");
		System.out.println("Zufallszahlengenerator: Well44497a,Apache Commons Math");
		
		int i, n = 150, 
			numberOfTrials = 10000000,
			counter = 0;		
		int[] shuffle = new int[n];
		double relative;
			
		System.out.println("Bitte warten!");
		
		for (i=0; i<numberOfTrials; i++) {
			shuffle = generator.nextPermutation(n,n);
			if (checkRencontre(n, shuffle))
				counter++;
		} 
		relative = (double)counter/numberOfTrials;
		
		System.out.println("Wir verwenden " + n + " Karten" + 
		" und wir mischen " + numberOfTrials + " mal!");
		System.out.println("Es gab " + counter + " Rencontres bei " 
		     + numberOfTrials + " Versuchen!");
		System.out.println("Die relative H�ufigkeit ist " + relative);
		
		// Jetzt noch die N�herung
		double approximation, error;
		approximation = 1.0/(1.0-relative);
		System.out.println("Unsere N�herung: " + approximation);
		System.out.println("Der exakte Wert: " + Math.E);
		error = Math.abs((approximation - Math.E)/Math.E);
		System.out.println("Der relative Fehler: " + error);
	}
	
	private static boolean checkRencontre(int n, int [] deck) 
	{
		int i = 0;
		boolean value = false;
		while (i<n) {
			if (deck[i] == i) {
				value=true;
				break;
			}
			i++;			
		}
		return value;
	}
	
	
}
