/**
 * Erstes Beispiel f�r den Einsatz einer Instanz des Zufallszahlengenerators
 * in Math.random().
 */
public class FirstRandom {

	public static void main(String[] args) {
		double x = Math.random();		
		System.out.println("Eine Pseudozufallszahl in Java: " + x);	
	    System.out.println("Eine zufällige Zahl zwischen 1 und 6: " + diceResult(x));
	}
	
	/**
	 * Umrechnung einer Zufallszahl in ein Würfelergebnis
	 * @param x Berechnete Zufallszahl im Einheitsintervall
	 * @return Würfelergebnis 1, 2, 3, 4, 5 oder 6
	 */
	private static int diceResult(double x) {
		return (int)(6.0*x +1);
	}
}
