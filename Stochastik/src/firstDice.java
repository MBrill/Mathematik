/**
 * Erzeugen von zufälligen Werten eines Würfels mit java.util.Random.nextInt(int n)
 */
public class firstDice {

	public static void main(String[] args) {
		int n = 6, val;
		
		System.out.println("Ein Würfel auf der Basis von java.util.Random");
		System.out.println("---------------------------------------------");		
		// Random erzeugen und danach nur noch diese Instanz verwenden
		java.util.Random generator = new java.util.Random();
		
		// 10 zufÃ¤llige WÃ¼rfelergebnisse ...
		System.out.println("Wir erzeugen 10 zufällige Würfelergebnisse!");
		for (int i=0; i<10; i++) {
			val = generator.nextInt(n)+1;
			System.out.print(val + " ");
		}
	}
}
