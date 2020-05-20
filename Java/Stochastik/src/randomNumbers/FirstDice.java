/**
 * Erzeugen von zufälligen Werten eines Würfels mit java.util.Random.nextInt(int n)
 */
public class FirstDice {

	public static void main(String[] args) {
		int n = 6, val;
		
		System.out.println("Ein W�rfel auf der Basis von java.util.Random");
		System.out.println("---------------------------------------------");		
		// Random erzeugen und danach nur noch diese Instanz verwenden
		java.util.Random generator = new java.util.Random();
		
		// 10 zuf�llige W�rfelergebnisse ...
		System.out.println("Wir erzeugen 10 zufällige Würfelergebnisse!");
		for (int i=0; i<10; i++) {
			val = generator.nextInt(n)+1;
			System.out.print(val + " ");
		}
	}
}
