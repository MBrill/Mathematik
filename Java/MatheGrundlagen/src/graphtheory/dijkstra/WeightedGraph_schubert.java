package graphtheory.dijkstra;


public class WeightedGraph_schubert {

	//! Konstruktor mit Anzahl der Ecken, Bewertung ist 0.0
    public WeightedGraph_schubert(int dim) 
    {
	    int i,j;
	    this.n = dim;
	    this.a = new double[n][n];
	    for (i=0; i<this.n; i++)
	       for (j=0; j<n; j++)
	          a[i][j] = 0.0;
    }

	//! Konstruktor mit Anzahl der Ecken und einer Bewertung
    public WeightedGraph_schubert(int dim, double[][] matrix) 
    {
	    int i,j;
	    this.n = dim;
	    this.a = new double[n][n];
	    for (i=0; i<this.n; i++)
	       for (j=0; j<n; j++)
	          a[i][j] = matrix[i][j];
    }  
    
    //! Zwei gegebene Ecken auf Adjazenz �berpr�fen
    public boolean checkAdjacency(int i, int j)
    {
        if (this.a[i][j] > 0.0)
            return true;
        else
            return false;
    }
    
    //! Die Grade aller Ecken zur�ckgeben
    public int[] getVertexDegrees() 
    {
        int[] degrees = new int[n];
        int i;
        for (i=0; i<n; i++)
        {
            degrees[i] = this.getDegree(i);
        }
        return degrees;
    }

    //! Die Anzahl der Kanten berechnen und zur�ckgeben
    public int getNumberOfEdges()
    {
        int i, j, edges;
        
        edges = 0;       
        for (i=0; i<this.n; i++)
        for (j=i; j<this.n; j++)
             if ((a[i][j] > 0.0))
                edges++;

        return edges;  
    } 
        
    //! Den Grad einer Ecke berechnen
    /*!
     * Falls ein ung�ltiger Eckpunktindex �bergeben wird
     * gibt die Funktion -1 zur�ck!
     */
    public int getDegree(int vertex) 
    {
        int j, sum;

        if (vertex >= 0 && vertex < n)
        {   
            sum = 0;
            for (j=0; j<n; j++)
            {
                if (this.a[vertex][j]>0.0)
                 sum++;
            }
            return sum;
        }
        else
            return -1;
    }  

    //! Die Anzahl der Eckpunkte zur�ckgeben
    public int getNumberOfVertices() 
    {
    	return this.n;
    }
        
    //! Das Hand-Shake Theorem �berpr�fen
    public boolean checkHandshake()
    {
        int i, sum;
        int[] degrees = new int[this.n];
        
        degrees = this.getVertexDegrees();
        int e = this.getNumberOfEdges();
        
        sum = 0;
        for (i=0; i<this.n; i++)
             sum += degrees[i];
             
        if (sum == 2*e)
            return true;
        else
            return false;
    }
        
    //! Die Adjazenzmatrix abfragen
    public double[][] getAdjacencyMatrix() 
    {
        double[][] matrix = new double[n][n];    
        int i,j;
        for (i=0; i<n; i++)
        for (j=0; j<n; j++)
            matrix[i][j] = this.a[i][j];
        return matrix;
    }
      
    //! Implementierung des Dijkstra Algorithmus
    /*!
     * Es werden alle k�rzesten Wege von der Startecke a berechnet
     * und als Vorg�ngerbaum zur�ckgegeben.
     *
     * Ist die Instanz kein zusammenh�ngender Graph, dann
     * gibt die Funktion false zur�ck.
     */
    public boolean dijkstra(int start)
    {
        int i,j;
        init(start);
        
        // �berpr�fen, ob es noch eine zu besuchende Ecke gibt
        boolean allReached = unVisited();
        
        boolean found = true;
        while ((!allReached) && found)
        {
            int nXmin = -1, nYmin = -1;
            double lMin=Double.MAX_VALUE;
            found = false;
            boolean first = true;
            
            for (i=0; i<n; i++)
            {
                if (inTree[i])
                {
                    for (j=0; j<n; j++)
                    {
                        if ((!inTree[j]) && checkAdjacency(i,j))
                        {
                            found = true;
                            if (first)
                            {
                                nXmin = i; 
                                nYmin = j;
                                lMin = length(i,j);
                                first = false;
                            }
                            else
                                if (lMin > length(i,j))
                                {
                                    nXmin = i;
                                    nYmin = j;
                                    lMin = length(i,j);
                                }
                        }
                    }
                }
            }
        
            if (!found) continue;
            // Punkt gefunden, Vorg�ngerbaum aktualisieren
            inTree[nYmin] = true;
            pre[nYmin] = nXmin;
            d[nYmin] = length(nYmin);
            
            // Wieder �berpr�fen, ob es noch Ecken gibt die
            // besucht werden m�ssen
            allReached = unVisited();
        }
        
        
        // Jetzt hier den Baum aufbauen ...
        wege = new int[n][];
        for (i=0; i<n; i++)
        {
            int anzahlstationen = 1;
            int pt = i;
            while (pre[pt] != -1)
            {
                pt = pre[pt];
                anzahlstationen++;
            }
            wege[i] = new int[anzahlstationen];
            pt = i;
            for (j=anzahlstationen-1; j>=0; j--)
            {
                wege[i][j] = pt;
                pt = pre[pt];
            }
        }
        return true;
    }

    //! Die berechneten Wege zur�ckgeben
    public int[][] getPaths()
    {
        return wege;
    }
    
    
    //! Die L�nge der berechneten Wege zur�ckgeben
    public double[] getLengths()
    {
        return d;
    }
    
    //! Gibt die L�nge des Weges vom aktuellen Ausgangsknoten zur Ecke i zur�ck
    private double length(int v)
    {
        int i;
        double sum;
        sum = 0.0;
        i = v;
        while (pre[i]!=-1)
        {
            sum+=this.a[pre[i]][i];
            i = pre[i];
        }
        return sum;
    }
    
    /*! 
     * Berechnet f�r die Ecke nX im Vorg�ngerbaum und die Ecke nY
     * ausserhalb des Vorg�ngerbaums, die mit nX �ber eine Kante verbunden ist
     * die L�nge des Weges von der Wurzel zur Ecke nY
     */
    private double length(int nX, int nY)
    {
        return length(nX) + this.a[nX][nY];
    }
    
    //! Den Algorithmus initialisieren
    private void init(int start)
    {
        int i;
        d = new double[n];
        pre = new int[n];
        inTree = new boolean[n];
         
        for (i=0; i<n; i++)
        {
            d[i] = Double.MAX_VALUE;
            pre[i] = -1;
            inTree[i] = false;
        }
        d[start] = 0;
        inTree[start] = true;
    }
  

    //! �berpr�fen, ob es noch unbesuchte Ecken gibt
    private boolean unVisited()
    {
        boolean all = true;
        for (int i=0; i<n && all; i++)
        {
            if (!inTree[i])
                all = false;
        }
        return all;
    }                
    
    //! Anzahl der Eckpunkte im Graphen
    private int n;    
    //! Die Adjazenzmatrix
    private double[][] a;   
    //! Der Vorg�ngerbaum f�r das Ergebnis des Dijkstra Algorithmus
    private int[] pre;
    //! Die Distanzen innerhalb des Vorg�ngerbaumes
    private double[] d;
    //! Menge mit Ecken im Vorg�ngerbaum
    private boolean[] inTree;
    //! Wege
    private int[][] wege;
    
}
