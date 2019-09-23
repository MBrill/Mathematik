//----------------------------------------------------------
// Filename:         Sieve.java
//----------------------------------------------------------
// Last Change :     August 27., 2009
//----------------------------------------------------------
import java.util.*;
import java.io.*;

/**
 * class Sieve
 * @author Manfred Brill
 * Sieve for the main program of a Java application
 * for the demonstration of mathematical algorithms.
 *
 * Uses the classes Scanner and Printstream.
 * The instances are called
 *    Scanner input;
 * and
 *    PrintStream output;
 *
 * the input-File has the name "Sieve.in"
 * The output-File has the name "Sieve.out"
 *
 */
public class Sieve {

   private static final String FileInputName = "Sieve.in";
   private static final String FileOutputName = "Sieve.out";  

   public static void main(String[] args) throws IOException
   {
      Scanner input = null;
      PrintStream output = null;
      int theLimit;     

      // Try-Block to catch IOExceptions
      try {
			input = new Scanner(new File(FileInputName));
			output = new PrintStream(new File(FileOutputName));
			
            theLimit = input.nextInt();
            
            BitSet thePrimes = new BitSet(theLimit);
            erathosthenes(theLimit, thePrimes); 
            

            output.println(pi(theLimit, thePrimes));
            output.println();
            
            for (int i=0; i<theLimit; i++)
            {
                if (thePrimes.get(i))
                    output.println(i);
            }                                             	
			
      } finally {
			if (input != null) input.close();
			if (output != null) output.close();
      }	
   }
   
   /**
    * The result of our sieve is an instance of BitSet.
    * If i is prime list[i] == true.
    */
   private static boolean erathosthenes(int limit, BitSet list)
   {
      int i, divisor, q;

      if (limit < 2) return false;
      for (i=2; i<limit; i++)
          list.set(i);
      
      divisor = 2;
      while (divisor*divisor <= limit)
      {
          q = 2;
          while (q*divisor <= limit)
          {
            list.set(q*divisor,false); 
            q++;
          }
          
          do
          {
            divisor++; 
          }
          while (list.get(divisor) == false);
      }
      return true;
   }  

   /**
    * The number of primes, the pi function, for a given
    * integer n.
    * 
    * Here we compute this value using the sieve and counting
    * how much boolean values "true" are in the BitSet.
    */
   private static int pi(int limit, BitSet list)
   {
      int result;
      
      result = 0;
      for (int i=0; i<limit; i++)
      {
          if (list.get(i)) result++;             
      } 
      return result;
   }      
}
