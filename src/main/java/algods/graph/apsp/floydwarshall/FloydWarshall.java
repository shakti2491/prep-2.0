package algods.graph.apsp.floydwarshall;

public class FloydWarshall {
    private static int INF = (int)1e9;

    public void floydWarshall(int [][] graph, int V){

        int[][] dist = new int[V][V];

        for( int i =0 ;i<V;i++){
            for(int j=0;j<V;j++){
                dist[i][j] = graph[i][j];
            }
        }

        for( int k=0; k<V; k++){
            for( int src=0; src<V; src++)
                for(int dest=0; dest<V; dest++){
                    if(dist[src][k]+dist[k][dest]<dist[src][dest])
                        dist[src][dest] = dist[src][k]+dist[k][dest];
                }
        }

        printSolution(dist, V);

    }

    private void printSolution(int[][] dist, int V) {
        for (int i=0; i<V; ++i)
        {
            for (int j=0; j<V; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
         /* Let us create the following weighted graph
           10
        (0)------->(3)
        |         /|\
        5 |          |
        |          | 1
        \|/         |
        (1)------->(2)
           3           */
        int graph[][] = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
        };

        new FloydWarshall().floydWarshall(graph,4);
    }
}
