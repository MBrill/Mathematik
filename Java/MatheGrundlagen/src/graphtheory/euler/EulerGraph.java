package graphtheory.euler;
/**
 * EulerGraph
 * @author Manfred Brill
 * 
 * Implementation of an undirected graph, represented by
 * by a adjacency matrix.
 *
 */
public class EulerGraph {
	
    // Default-Construktor
    public EulerGraph() 
    {
	    this.n = 1;
	    this.a = new int[1][1];
	    a[0][0] = 0;
    }
	
	// Constructor with dimension; no matrix
    public EulerGraph(int dim) 
    {
	    int i,j;
	    this.n = dim;
	    this.a = new int[n][n];
	    for (i=0; i<this.n; i++)
	       for (j=0; j<n; j++)
	          a[i][j] = 0;
    }

	// Constructor with dimension and adjacency matrix
    public EulerGraph(int dim, int[][] matrix) 
    {
	    int i,j;
	    this.n = dim;
	    this.a = new int[n][n];
	    for (i=0; i<this.n; i++)
	       for (j=0; j<n; j++)
	          a[i][j] = matrix[i][j];
    }    

    // Check if two vertices are adjacent
    public boolean checkAdjacency(int i, int j)
    {
        if (this.a[i][j] > 0)
            return true;
        else
            return false;
    }

    // Check if the graph is simple
    public boolean isSimple()
    {
        int i,j;
        
        for (i=0; i<this.n; i++)
        for (j=0; j<this.n; j++)
             if ((a[i][j] < 0) || (a[i][j] > 1))
                return false;
        
        return true;
    }
    
    // Get the number of vertices
    public int getNumberOfVertices() 
    {
    	return this.n;
    }

    // Get the number of edges in the graph
    public int getNumberOfEdges()
    {
        int i, j, edges;
        
        edges = 0;
        
        for (i=0; i<this.n; i++)
        for (j=i; j<this.n; j++)
             if ((a[i][j] > 0))
                edges++;
                
        return edges;  
    } 
        
    // Get the degrees of all vertices
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

    /**
     * If the index is not valid, the function
     * returns -1!
     */
    public int getDegree(int vertex) 
    {
        int j, sum;

        if (vertex > 0 || vertex < n)
        {   
            sum = 0;
            for (j=0; j<n; j++)
                 sum += this.a[vertex][j];
            return sum;
        }
        else
            return -1;
    }  
      
    /**
     *  If at least one vertex has odd degree the function
     *  returns false.
     */
    public boolean checkCircuit()
    {
        int i;
        
        for (i=0; i<this.n; i++)
        {
            if (getDegree(i)%2 == 1)
                return false;
        }
        return true;
    }
    
    public int[] computeCircuit()
    {
        int i, j, activeVertex, 
            circuitLength,
            numberEdges = this.getNumberOfEdges();
        // Take a copy of the adjacency matrix, we will
        // work on that copy
        int[][] ad = new int[this.n][this.n];
        
        for (i=0; i<this.n; i++)
        for (j=0; j<this.n; j++)
            ad[i][j] = this.a[i][j];
            
        int[] circuit = new int[2*numberEdges];
        
        // Start at vertex #0
        circuit[0] = 0;
        circuitLength = 0;
        
        boolean success;
        
        do {
            success = false;
            activeVertex = circuit[circuitLength];
            
            for (i=0; (i<this.n)&&!success; i++) {
                if (ad[activeVertex][i] > 0)
                {
                    circuitLength++;
                    circuit[circuitLength] = i;
                    ad[activeVertex][i]--;
                    ad[i][activeVertex]--;
                    success = true;
                }
            }
            
            if (!success) {
                int k;
                // Breakout!
                // Take care, circuitLength is already increased before
                // we reach that step!               
                for (i=1; (i<circuitLength)&&!success; i++) 
                for (j=0; (j<this.n)&&!success; j++) {
                      // Something left?                      
                      if (ad[circuit[i]][j] > 0) 
                      {                     
                        int[] circuitTemp = new int[circuitLength+1];
                         
                        for (k=i; k<circuitLength; k++) {
                            circuitTemp[k-i] = circuit[k];
                        }                            
                        for (k=0; k<i; k++) {
                            circuitTemp[circuitLength-i+k] = circuit[k];
                        }
                        circuitTemp[circuitLength] = i;                         
                            
                        for (k=0; k<=circuitLength; k++) {
                            circuit[k] = circuitTemp[k];
                        }                                                                                                       
   
                        success = true;
                      }
                  }                 
               }
               
            } while (success);
        
        // Create the return-circuit
        int[] retCircuit = new int[circuitLength+1];
        for (i=0; i<=circuitLength; i++)
            retCircuit[i] = circuit[i];
            
        return retCircuit;
    }
    
    /// Check if for the graph the Handshaking Theorem is valid
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
                    
    /// Get the adjacency matrix
    public int[][] getAdjacencyMatrix() 
    {
        int[][] matrix = new int[n][n];    
        int i,j;
        for (i=0; i<n; i++)
        for (j=0; j<n; j++)
            matrix[i][j] = this.a[i][j];
        return matrix;
    }

    //! Number of vertices
    private int n;    
    //! Adjacency matrix
    private int[][] a;  
}
