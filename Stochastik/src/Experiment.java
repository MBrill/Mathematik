/**
 * Experiment zweimal würfeln und Augensumme berechnen.
 * 
 * Das Experiment wird zweimal ausgeführt. Einmal mit einer Instanz von
 * LinearCongruentalGenerator, und einmal mit einer Instanz eines MersenneTwisters
 * aus der Apache Common Math API.
 */
public class Experiment {

	public static void main(String[] args) {
		TwoDiesCongruental experiment1 = new TwoDiesCongruental();
		TwoDiesTwister     experiment2 = new TwoDiesTwister();
		
		/* Wir speichern die absoluten Häufigkeiten in einem int-Feld
		 * Dabei ist die Augensumme 2 in ergebnis[0],
		 * die Summe 3 in ergebnis[1] und allgemein
		 * die Summe k in ergebnis[k-2].
		 * Insgesamt benötigen wir 11 Feldelemente 
		 */
		int[] ergebnis = new int[11];
		// Wie oft möchten wir würfeln?
		final int n=100000;
		// Variable für das aktuelle Ergebnis
		int value, i, summe;
		
		// 1. Würfeln mit dem linearen Kongruenz-Generator
		for (i=0; i<n; i++) {
			value = experiment1.throwDies();
			ergebnis[value-2]++;
		}
		
		// Die Ergebnisse ausgeben
		/*for (i=0; i<11; i++) {
			value = i+2;
			System.out.println("Augensumme = " + value + " : " + ergebnis[i]);
		}*/
		
		// Check, ob die Ergebnisse plausibel sind
		// Die Summe der Häufigkeiten muss mit der Variable n,
		// der Anzahl der Durchführungen,übereinstimmen.
		summe = 0;
		for (i=0; i<11; i++)
			summe += ergebnis[i];
		
		if (summe != n)
			System.out.println("Die Summe der Häufigkeiten stimmt nicht mit n überein!");
		
		// Die Ergebnisse ausgeben
		System.out.println("Ergebnisse mit dem linearen Kongruenz-Generator");
		System.out.println("-----------------------------------------------");
		System.out.println("Ausgabe der Häufigkeiten als Liste");
		for (i=0; i<11; i++) {
			System.out.print(ergebnis[i] + ";");
		}
		
		// Experiment wiederholen, jetzt mit einem MersenneTwister
		
		// HÃ¤ufigkeiten zurücksetzen
		for (i=0; i<11; i++) 
			ergebnis[i] = 0;
		
		for (i=0; i<n; i++) {
			value = experiment2.throwDies();
			ergebnis[value-2]++;
		}
		
		// Check, ob die Ergebnisse plausibel sind
		// Die Summe der Häufigkeiten muss mit der Variable n,
		// der Anzahl der Durchführungen, übereinstimmen.
		summe = 0;
		for (i=0; i<11; i++)
			summe += ergebnis[i];
		
		if (summe != n)
			System.out.println("Die Summe der Häufigkeiten stimmt nicht mit n überein!");
		
		
		// Die Ergebnisse ausgeben
		System.out.println("\n\nErgebnisse mit dem Mersenne Twister");
		System.out.println("-----------------------------------");
		System.out.println("Ausgabe der Häufigkeiten als Liste");
		for (i=0; i<11; i++) {
			System.out.print(ergebnis[i] + ";");
		}
	}
}
