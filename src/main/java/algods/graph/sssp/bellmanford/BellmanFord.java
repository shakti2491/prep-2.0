package algods.graph.sssp.bellmanford;

public class BellmanFord {
    public void singleSourceShortestPath(int[][] edgeWithWeights, int V, int src){
        // Initialize distance of all vertices as infinite.
        int []dist = new int[V];
        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;
        // initialize distance of source as 0
        dist[src] = 0;
        // Relax all edges |V| - 1 times. A simple
        // shortest path from src to any other
        // vertex can have at-most |V| - 1 edges
        for(int i = 1; i<V;i++){
            for(int[] edge : edgeWithWeights){
                int u =edge[0];
                int v = edge[1];
                int w = edge[2];
                if(dist[u]!=Integer.MAX_VALUE && dist[u]+w < dist[v]){
                    dist[v] = dist[u]+w;
                }
            }
        }

        // check for negative-weight cycles.
        // The above step guarantees shortest distances if graph doesn't contain
        // negative weight cycle. If we get a shorter path, then there is a cycle.

        for(int[] edge : edgeWithWeights){
            int u =edge[0];
            int v = edge[1];
            int w = edge[2];
            if(dist[u]!=Integer.MAX_VALUE && dist[u]+w < dist[v]){
                System.out.println("Graph contains negative weight cycle.");
            }
        }
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args)
    {
        int V = 5; // Number of vertices in graph
        // Every edge has three values (u, v, w) where
        // the edge is from vertex u to v. And weight
        // of the edge is w.
        int graph[][] = { { 0, 1, -1 }, { 0, 2, 4 },
                { 1, 2, 3 }, { 1, 3, 2 },
                { 1, 4, 2 }, { 3, 2, 5 },
                { 3, 1, 1 }, { 4, 3, -3 } };

        new BellmanFord().singleSourceShortestPath(graph, V,  0);
    }
}
