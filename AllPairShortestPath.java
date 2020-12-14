import java.util.Scanner;

//to test different size arrays, change V to number of verticies and write the table in the main method
class AllPairShortestPath 
{ 
    final static int INF = 99999, V = 5; 
  
    int[][] floyd(int W[][], int P[][]) 
    {
        
    	int D[][] = new int[V][V]; 

        int i, j, k; 
  
        for (i = 0; i < V; i++) {
            for (j = 0; j < V; j++) {
                D[i][j] = W[i][j]; 
            }
        }
  
        for (k = 0; k < V; k++) 
        {
            for (i = 0; i < V; i++) 
            { 
                for (j = 0; j < V; j++) 
                { 
                    if (D[i][k] + D[k][j] < D[i][j]) {
                        D[i][j] = D[i][k] + D[k][j]; 
                        P[i][j] = k+1;
                    }
                } 
            } 
        } 
  
        printSolution(D, P);
		return P;
    } 
  
    void printSolution(int D[][], int[][] P) 
    { 
        System.out.println("D array:"); 
        for (int i=0; i<V; ++i) 
        { 
            for (int j=0; j<V; ++j) 
            { 
                if (D[i][j]==INF) 
                    System.out.print("INF "); 
                else
                    System.out.print(D[i][j]+"   "); 
            } 
            System.out.println(); 
        }
        
        System.out.println("P array:"); 
        for (int i=0; i<V; ++i) 
        { 
            for (int j=0; j<V; ++j) 
            { 
                if (P[i][j]==INF) 
                    System.out.print("INF "); 
                else
                    System.out.print(P[i][j]+"   "); 
            } 
            System.out.println(); 
        }
    } 
 

	public static void main (String[] args) 
    { 
    	Scanner sc = new Scanner(System.in);
        int graph[][] = { {0, 1, INF, 1, 5}, 
                          {9, 0, 3, 2, INF}, 
                          {INF, INF, 0, 4, INF}, 
                          {INF, INF, 2, 0, 3},
                          {3, INF, INF, INF, 0}
                        }; 
        int graph2[][] = {  {0, 0, 0, 0, 0}, 
                			{0, 0, 0, 0, 0}, 
                			{0, 0, 0, 0, 0}, 
                			{0, 0, 0, 0, 0},
                			{0, 0, 0, 0, 0}
              }; 
        AllPairShortestPath a = new AllPairShortestPath();
        a.floyd(graph, graph2); 
        int vertex1;
        int vertex2;
        System.out.println("Menu:");
        System.out.println("1. Find path");
        System.out.println("2. Exit");
        int choice;
        choice = sc.nextInt();
        switch(choice) {
        case 1:
        	System.out.println("Please choose a vertex");
            vertex1 = sc.nextInt();
            System.out.println("Please choose another vertex");
            vertex2 = sc.nextInt();
            a.path(vertex1, vertex2, a.floyd(graph, graph2));
            break;
        case 2:
        	break;
        }
        
        sc.close();
    }
    
    public void path(int q, int r, int[][] P) {
    	if (P[q][r] != 0) {
   		path(q, P[q][r], P);
    		System.out.println("v" + P[q][r]);
   		path(P[q][r], r, P);
    	}
    }

}
