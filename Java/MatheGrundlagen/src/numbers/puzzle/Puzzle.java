/**
 * Implementierung des Puzzle aus der CACM
 *
 * Die Anwendung liest vier natürliche Zahlen ein.
 * 
 * Das Ergebnis wird in eine Datei geschrieben. Der
 * Algorithmus stoppt immer mit einer Zeile 0 0 0 0.
 * Quelle: Communications of the ACM, 5/2009 vol. 52 (2), p. 112.
 *
 * Eingabedatei: "Puzzle.in"
 * Ausgabedatei: "Puzzle.out".
 */
package numbers.puzzle;
import java.util.*;
import java.io.*;

public class Puzzle {

   private static final String FileInputName = "Puzzle.in";
   private static final String FileOutputName = "Puzzle.out";  

   public static void main(String[] args) throws IOException
   {
      Scanner input = null;
      PrintStream output = null;
      int a, b, c, d, newa, newb, newc, newd;     

      // Try-Block to catch IOExceptions
      try {
			input = new Scanner(new File(FileInputName));
			output = new PrintStream(new File(FileOutputName));
			
            a = input.nextInt();  
            b = input.nextInt();
            c = input.nextInt();  
            d = input.nextInt();
            
            // Print the starting values in the output file
            output.println(a + "  " + b + "  " + c + "  " + d);
            
            while ( (a>0) && (b>0) && (c>0) && (d>0)) 
            {

                newa = Math.abs(a-b);
                newb = Math.abs(b-c);
                newc = Math.abs(c-d);
                newd = Math.abs(d-a);
                
                a = newa;
                b = newb;
                c = newc;
                d = newd;
                
                output.println(a + "  " + b + "  " + c + "  " + d);                
            }                                                       	
			
      } finally {
			if (input != null) input.close();
			if (output != null) output.close();
      }	
   }      
}
