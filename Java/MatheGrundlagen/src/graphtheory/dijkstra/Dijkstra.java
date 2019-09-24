package graphtheory.dijkstra;

import java.util.*;
import java.io.*;

/**
 * Die Klasse verwendet eine Instanz der Klasse WeightedGraph.
 *
 * Die Eingabedaten werden mit Hilfe einer Instanz der Klasse Scanner
 * aus einer ASCII-Datei eingelesen. Die Instanz dieser Klasse hat den Namen
 * input. Als Dateiname wird Dijkstra.in verwendet.
 *
 * Die Syntax dieser Eingabedatei ist dabei wie folgt:
 *
 * n: Anzahl der Eckpunkte im Graphen
 *
 * s1 s2 ... sn: Strings mit Namen der n Eckpunkte
 *
 * a a a a a a 
 * ...
 * a a a a a a: Adjazenzmatrix mit double-Werten.
 *
 * start: Index des Startpunkts
 *
 * Beachten Sie, dass die double-Werte in der Adjazenzmatrix mit einem Komma als Dezimaltrenner
 * erwartet werden!
 *
 * Die Ausgabe der Applikation erfolgt mit Hilfe einer Instanz der Klasse PrintStream.
 * Die Instanz tr�gt den Namen output, als Dateiname wird Dijkstra.out verwendet.
 * Die Formatierung der Ausgabe erfolgt in der Funktion
 * Dijkstra::printResults.
 *
 * Die Ausgabe ist zur Zeit wie folgt formatiert:
 * F�r jeden Eckpunkt des Graphen wird der berechnete k�rzeste Weg (Funktion Dijkstra::constructPaths)
 * angegeben, gefolgt von der L�nge dieses Weges. Bei der Ausgabe werden die Namen der Eckpunkte verwendet.
 *
 * Ist der Graph nicht zusammenh�ngend wird dies in der Ausgabedatei angegeben.
 */
public class Dijkstra 
{
    // Dateiname f�r die Eingabedaten
    private static final String FileInputName = "Dijkstra.in";
    // Dateiname f�r die Ausgabedaten
    private static final String FileOutputName = "Dijkstra.out";  

    // Main-Funktion der Application
    public static void main(String[] args) throws IOException
    {
      Scanner input = null;
      PrintStream output = null;

      // Try-Block f�r IOExceptions
      try {
			input = new Scanner(new File(FileInputName));
			output = new PrintStream(new File(FileOutputName));
			
			int i, j, n, start, end, route;
					
			// Die Anzahl der Ecken einlesen
            n = input.nextInt(); 
            			
            // Die Namen
            String[] namen = new String[n];
            for (i=0; i<n; i++)
                 namen[i] = input.next();
                 					
            // Die Adjazenzmatrix dimensionieren			 
			double[][] a = new double[n][n];
 
            for (i=0; i<n; i++)
                for (j=0; j<n; j++) 
                    a[i][j] = input.nextDouble();
                    
            route = input.nextInt();
            start = input.nextInt();
            end = input.nextInt();
            
            WeightedGraph g = new WeightedGraph(n, namen, a);
            		
            if (!g.checkHandshake())
                output.println("Kein zul�ssiger Graph!");
                                                 						                            
            int[] spanningTree = new int[g.getNumberOfVertices()];
            boolean result;

            // Alle k�rzesten Wege berechnen
            if (route == 0)
            {       
                result = g.dijkstra(start, spanningTree);
                if (!result)
                {
                    output.println("Kein zusammenh�ngender Graph!");
                }  
                else
                { 
                    double[] distances = g.getLengths();
                    printResults(output, namen, 
                                 spanningTree, distances);
                } 
            }                       	
            else // Nur von start nach end suchen
            {
               int length=0;
               int[] path = new int[n]; 
               result = g.shortestPath(start, end, length, path); 
               if (!result)
               {
                    output.println("Kein zusammenh�ngender Graph!");
               }  
               else
               {                    
                    printPath(output, namen, start, end, path);
                    output.println(" ");
                    output.println("Die L�nge des Weges ist " + g.getLength(end));
               }
            }
			
      } 
      finally 
      {
			if (input != null) input.close();
			if (output != null) output.close();
      }	
    }  
    
    // Konstruktion der k�rzesten Wege auf der Basis des Vorg�ngerbaums
    private static final void constructPaths(int[] pre, int[][] paths)
    {
        int n = pre.length;
        for (int i=0; i<n; i++)
        {
            int count = 1;
            int pt = i;
            while (pre[pt] != -1)
            {
                pt = pre[pt];
                count++;
            }
            paths[i] = new int[count];
            pt = i;
            for (int j=count-1; j>=0; j--)
            {
                paths[i][j] = pt;
                pt = pre[pt];
            }
        }
    }

    // Ausgabe der Resultate
    private static final void printResults(PrintStream out,
                                           String[] namen,
                                           int[] tree,
                                           double[] distances)
    {
          int n = tree.length;
          int[][] paths = new int[n][];

          constructPaths(tree, paths);                       
          for (int i=0; i<n; i++)
          {
              out.print(namen[i] + " : ");
              for (int j=0; j<paths[i].length-1; j++)
                   out.print(namen[paths[i][j]] + " , ");
              out.print(namen[paths[i][paths[i].length-1]]);
              
              out.println(" : distanz(" + namen[paths[i][0]] + "," + 
                            namen[paths[i][paths[i].length-1]] + ") = " 
                            + distances[i]);
          }         
    }
    
    // Ausgabe der Resultate f�r einen k�rzesten Weg
    private static final void printPath(PrintStream out,
                                        String[] namen,
                                        int start, int end, 
                                        int[] tree)
    {                   
        out.println("Der k�rzeste Weg zwischen " + namen[start] + " und " + namen[end] + ":");
        // Jetzt noch den Weg aus dem Vorg�ngerbaum
        // extrahieren und zur�ckgeben.
        int j, count = 1, pt = end;
        // Feststellen wie lange der Weg ist:
        while (tree[pt] != -1)
        {
            pt = tree[pt];
            count++;
        }
        // Jetzt den Weg �bertragen
        pt = end;
        int[] path = new int[count];
        for (j=count-1; j>=0; j--)
        {
            path[j] = pt;
            pt = tree[pt];
        }
        
        for (j=0; j<count-1; j++)
                   out.print(namen[path[j]] + " , ");
        out.print(namen[path[count-1]]);
              
    }   
}