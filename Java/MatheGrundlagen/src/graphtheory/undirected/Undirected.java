package graphtheory.undirected;

import java.util.*;
import java.io.*;

/**
 * Application for undirected graphs.
 * 
 * @author Manfred Brill
 * 
 * Read in the adjacency matrix of a undirected graph
 * and compute numbers and atttribues for
 * this graph.
 *
 * The input file "Undirected.in":
 * n the number of vertices in the graph
 * nxn numbers, the adjacency matrix.
 *
 * The last two numbers are vertex numbers. The program
 * has to check, if the two vertices are adjacent.
 * Remember, we number the vertices beginning with 0.
 *
 * The output file "Undirected.out":
 * - is the graph simple?
 * - degrees of all vertices
 *
 */
public class Undirected {

   private static final String FileInputName = "Undirected.in";
   private static final String FileOutputName = "Undirected.out";

   public static void main(String[] args) throws IOException
   {
      Scanner input = null;
      PrintStream output = null;  

      // Try-Block to catch IOExceptions
      try {
			input = new Scanner(new File(FileInputName));
			output = new PrintStream(new File(FileOutputName));
			
			int i, j, n, verta, vertb;
			int[][] a;
			
            n = input.nextInt(); 
            			
			a = new int[n][n];
 
            for (i=0; i<n; i++)
                for (j=0; j<n; j++) 
                    a[i][j] = input.nextInt();
                    
            verta = input.nextInt();
            vertb = input.nextInt();
            
            UndirectedGraph g = new UndirectedGraph(n,a);
            
            if (g.isSimple())
                output.println("A simple graph");
            else
                output.println("A graph with loops or parallel edges!");

			output.println("Number of Edges " + g.getNumberOfEdges());
			
            if (g.checkHandshake())
                output.println("The Handshaking Theorem is valid");
                                                 						             
            int[] degrees = new int[n];
            degrees = g.getVertexDegrees();  
            
            for (i=0; i<n; i++)
                output.println("degree( " + i + " ) = " + degrees[i]);
                
            // Vertices adjacent?

            if (g.checkAdjacency(verta, vertb))
                output.println("Vertices " + verta + " and " + vertb + " are adjacent");             


			
      } finally {
			if (input != null) input.close();
			if (output != null) output.close();
      }	
   }      
}
