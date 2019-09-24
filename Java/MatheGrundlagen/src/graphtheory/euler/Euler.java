//----------------------------------------------------------
// Filename:         Euler.java
//----------------------------------------------------------
// Last Change :     August 28., 2009
//----------------------------------------------------------

import java.util.*;
import java.io.*;

/**
 * class Euler
 * @author Manfred Brill
 * 
 * Read in the adjacency matrix of a undirected graph
 * and check, if it is a Euler graph.
 *
 * The input file "Undirected.in":
 * n the number of vertices in the graph
 * nxn numbers, the adjacency matrix.
 *
 * The output file "Undirected.out":
 * - are all degrees of the vertices even?
 * - degrees of all vertices.
 *
 */
public class Euler {

   private static final String FileInputName = "Euler.in";
   private static final String FileOutputName = "Euler.out";
   private static int n;

   public static void main(String[] args) throws IOException
   {
      Scanner input = null;
      PrintStream output = null;  

      // Try-Block to catch IOExceptions
      try {
			input = new Scanner(new File(FileInputName));
			output = new PrintStream(new File(FileOutputName));
			
			int i, j, n;
			int[][] a;
			
            n = input.nextInt(); 
            		
			a = new int[n][n];
 
            for (i=0; i<n; i++)
                for (j=0; j<n; j++) 
                    a[i][j] = input.nextInt();
                    
            
            EulerGraph g = new EulerGraph(n,a);
            
            if (g.checkCircuit())
                output.println("This graph contains an Euler circuit!");
            else
                output.println("This graph does not contain an Euler circuit!");
            

            int[] circuit = new int[2*g.getNumberOfEdges()];
            // Compute the Euler Circuit, if it exists
            if (g.checkCircuit())
            {
                circuit = g.computeCircuit();
            } 
            
            // Print the Euler circuit
            output.println("The Euler circuit: \n");
            for (i=0; i<circuit.length; i++)
            {
                output.print(circuit[i] + " ");
            }         
			
      } finally {
			if (input != null) input.close();
			if (output != null) output.close();
      }	
   }      
}
