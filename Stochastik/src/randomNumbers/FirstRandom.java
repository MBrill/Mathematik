/**
 * Erstes Beispiel f�r den Einsatz einer Instanz des Zufallszahlengenerators
 * in Math.random().
 */
public class FirstRandom {

	public static void main(String[] args) {
		double x = Math.random();
		
		System.out.println("Meine erste Pseudozufallszahl in Java: " + x);
		
		// Jetzt eine zuf�lige int-Variable zwischen 1 und 6
		int w = 1 + (int)(Math.random()*6.0);
	    System.out.println("Eine zuf�llige Zahl zwischen 1 und 6: " + w);
	}
}
