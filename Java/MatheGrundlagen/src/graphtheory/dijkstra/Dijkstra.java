import java.util.*;
import java.io.*;

//! Applikation
/*!
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
 * Die Instanz trägt den Namen output, als Dateiname wird Dijkstra.out verwendet.
 * Die Formatierung der Ausgabe erfolgt in der Funktion
 * Dijkstra::printResults.
 *
 * Die Ausgabe ist zur Zeit wie folgt formatiert:
 * Für jeden Eckpunkt des Graphen wird der berechnete kürzeste Weg (Funktion Dijkstra::constructPaths)
 * angegeben, gefolgt von der Länge dieses Weges. Bei der Ausgabe werden die Namen der Eckpunkte verwendet.
 *
 * Ist der Graph nicht zusammenhängend wird dies in der Ausgabedatei angegeben.
 */
public class Dijkstra 
{
    //! Dateiname für die Eingabedaten
    private static final String FileInputName = "Dijkstra.in";
    //! Dateiname für die Ausgabedaten
    private static final String FileOutputName = "Dijkstra.out";  

    //! Main-Funktion der Application
    public static void main(String[] args) throws IOException
    {
      Scanner input = null;
      PrintStream output = null;

      // Try-Block für IOExceptions
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
                output.println("Kein zulässiger Graph!");
                                                 						                            
            int[] spanningTree = new int[g.getNumberOfVertices()];
            boolean result;

            // Alle kürzesten Wege berechnen
            if (route == 0)
            {       
                result = g.dijkstra(start, spanningTree);
                if (!result)
                {
                    output.println("Kein zusammenhängender Graph!");
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
                    output.println("Kein zusammenhängender Graph!");
               }  
               else
               {                    
                    printPath(output, namen, start, end, path);
                    output.println(" ");
                    output.println("Die Länge des Weges ist " + g.getLength(end));
               }
            }
			
      } 
      finally 
      {
			if (input != null) input.close();
			if (output != null) output.close();
      }	
    }  
    
    //! Konstruktion der kürzesten Wege auf der Basis des Vorgängerbaums
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

    //! Ausgabe der Resultate
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
    
    //! Ausgabe der Resultate für einen kürzesten Weg
    private static final void printPath(PrintStream out,
                                        String[] namen,
                                        int start, int end, 
                                        int[] tree)
    {                   
        out.println("Der kürzeste Weg zwischen " + namen[start] + " und " + namen[end] + ":");
        // Jetzt noch den Weg aus dem Vorgängerbaum
        // extrahieren und zurückgeben.
        int j, count = 1, pt = end;
        // Feststellen wie lange der Weg ist:
        while (tree[pt] != -1)
        {
            pt = tree[pt];
            count++;
        }
        // Jetzt den Weg übertragen
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

/*!
 * \mainpage 
 * 
 * <H1>Multimediaprojekt Wintersemester 2009/2010</H1> 
 * <CENTER>
 * <H2>Graphentheoretische Konzepte und Algorithmen</H2>
 * <H2>Prof. Dr. Manfred Brill</H2>
 * </CENTER>
 *
 * <BR>
 * \image html example.jpg
 *
 * <BR>
 * <H3>Ein- und Ausgabe</H3>
 * Die Aufgabenstellung wird in der Datei Dijkstra.in eingegeben, die Datei Dijkstra.out enthält
 * die Ergebnisse.
 *
 * In der Eingabedatei mit dem Namen Dijkstra.in geben Sie die Anzahl der Eckpunkte des Graphen an,
 * gefolgt von den Namen der Eckpunkte, der Adjanzenzmatrix und der Startecke.
 *
 * Das Beispiel aus den Folien des Workshops als Eingabedatei sieht dann wie folgt aus:
 *
 * <HR>
 * 6
 *
 * a b c d e f
 *
 * 0,0 4,0 0,0 2,0 0,0 0,0
 *
 * 4,0 0,0 3,0 0,0 3,0 0,0
 *
 * 0,0 3,0 0,0 0,0 0,0 2,0
 *
 * 2,0 0,0 0,0 0,0 3,0 0,0
 *
 * 0,0 3,0 0,0 3,0 0,0 1,0
 *
 * 0,0 0,0 2,0 0,0 1,0 0,0
 *
 * 0 0 4
 * <HR>
 *
 * In der Ausgabedatei wird für jeden Eckpunkt des Graphen der berechnete 
 * kürzeste Weg von der verwendeten
 * Startecke aus angegeben; dabei werden die Namen der Eckpunkte verwendet. 
 * Abschließend wird die Länge
 * des kürzesten Weges angegeben.
 *
 * Für die oben angegebene Eingabedatei wird dann die folgende 
 * Ausgabedatei erzeugt:
 *
 * <HR>
 * a : a : distanz(a,a) = 0.0
 * 
 * b : a , b : distanz(a,b) = 4.0
 *
 * c : a , b , c : distanz(a,c) = 7.0
 *
 * d : a , d : distanz(a,d) = 2.0
 *
 * e : a , d , e : distanz(a,e) = 5.0
 *
 * f : a , d , e , f : distanz(a,f) = 6.0
 * <HR>
 *
 * Geben Sie nach der Adjazenzmatrix als erste Zahl eine 1 ein, dann
 * Indices dazu verwendet, um den kürzesten Weg zwischen den beiden Knoten
 * zu bestimmen, statt aller Wege.
 *
 * <H3>Weitere Eingabedateien</H3>
 * Zusätzlich zu dieser Eingabedatei stehen weitere Dateien zur Verfügung, die als Testfälle
 * verwendet werden können. Kopieren Sie die Dateien in Dijkstra.in und führen Sie die Applikation
 * neu aus, um das Ergebnis zu erhalten. Die Originaldatei kann mit Hilfe der Datei
 * <slide.in> wieder rekonstruiert werden.
 *
 * -# slide.in: Eingabedatei mit dem Folienbeispiel, wie oben angegeben. 
 * -# mathebuch.in: Eingabedatei mit einem Beispiel aus Manfred Brill, Mathematik für Informatiker (2. Auflage), mit dem Beispiel aus Abbildung 7.30 auf Seite 182.
 * -# schubert.in: Eingabedatei mit einem Beispiel aus Matthias Schubert: Mathematik für Informatiker, mit dem Beispiel aus Bild 15-5 auf Seite 407.
 * -# unconnected.in: Ein unzusammenhängender Graph als Testbeispiel für eine negative Antwort.
 */
