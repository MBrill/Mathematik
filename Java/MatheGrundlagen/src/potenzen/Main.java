import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        int i, exponent, basis = 2;

	System.out.println("----------------------------");
	System.out.println("Berechnung einer Potenz 2^n");
	System.out.println("----------------------------");
	exponent = readInt();

	Power beispiel = new Power(basis, exponent);

	System.out.println("----------------------------");
	System.out.println("n    & Anzahl der Durchläufe");
	System.out.println("----------------------------");
	for (i=1; i<=exponent; i++) {
		beispiel.setExponent(i);
		beispiel.compute2();
	        System.out.println(i + "    & " + beispiel.getCounter());
	}
    }

    public static int readInt() throws IOException {
                BufferedReader in = new BufferedReader(
			               new InputStreamReader(System.in));
                                         
  
                System.out.print("Bis zu welchem Exponenten sollen die Schleifendurchläufe gezählt werden: ");
                return Integer.parseInt(in.readLine());
    } 
}
