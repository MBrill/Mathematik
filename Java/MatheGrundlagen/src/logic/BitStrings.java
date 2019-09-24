package logic;

import java.util.*;
import java.io.*;

/**
 * Bit Strings und logische Operatoren mit der Klasse BitSet.
 *
 * @author Manfred Brill
 */
public class BitStrings {

   private static final String FileInputName = "BitStrings.in";
   private static final String FileOutputName = "BitStrings.out";  

   public static void main(String[] args) throws IOException
   {
      Scanner scanner = null;
      PrintStream out = null;     

      int i, length,  operator;

      try {
			scanner = new Scanner(new File(FileInputName));
			out = new PrintStream(new File(FileOutputName));
			
            length = scanner.nextInt();
            
            // operator decides, if we want a conjunction (0), disjunction (1)
            // or an xor (2). A number != 0, 1,2 is treated like 0!            
            operator = scanner.nextInt();
            
            BitSet a = new BitSet(length);
            BitSet b = new BitSet(length);
            
            for (i=0; i<length; i++)
            {
                if (scanner.nextInt() == 1) a.set(i);
            }
            for (i=0; i<length; i++)
            {
                if (scanner.nextInt() == 1) b.set(i);
            }   
            
            // Now we apply the operator
            out = new PrintStream(new File(FileOutputName));            
                       
            switch (operator) {
                case 0: a.and(b);
                        break;
                case 1: a.or(b);
                        break;                
                case 2: a.xor(b);
                        break;                
                default: a.and(b);
                         break;
            }

            print(length, a, out);                                                  	
			
      } finally {
			if (scanner != null) scanner.close();
			if (out != null) out.close();
      }	
   }
   
   /**
    * Print the bit string. We use blanks every fourth bit (from left to right)
    * to make it more readable.
    *
    * @param length The length of the bit string to print
    * @param x The bit string to print
    * @param stream The PrintStream to use
    */    
   static private void print(int length, BitSet x, PrintStream stream)
   {
      int i, everyFourth;
      
      everyFourth = 1;
      
      for (i=0; i<length; i++)
      {
        
                if (x.get(i)) 
                {
                    stream.print("1");
                }
                else
                {
                    stream.print("0");
                }
                if ( everyFourth % 4 == 0 )
                {
                    stream.print(" ");
                }                                
                everyFourth++;                
     }
   }       
}
