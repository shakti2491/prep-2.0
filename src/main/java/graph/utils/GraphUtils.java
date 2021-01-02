package graph.utils;

import java.util.ArrayList;

public class GraphUtils {
    public static void buildGraph(int[][] pre , ArrayList[] adjList, int[] inDeg){
        for(int i=0; i<adjList.length;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int[] edge : pre){
            int v = edge[0];
            int u = edge[1];
            adjList[u].add(v);
            inDeg[v]++;
        }
    }
}
