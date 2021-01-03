package algods.graph.utils;

import java.util.ArrayList;

public class GraphUtils {
    public static void buildGraph(int[][] edges , ArrayList[] adjList, int[] inDeg){
        for(int i=0; i<adjList.length;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int v = edge[0];
            int u = edge[1];
            adjList[u].add(v);
            inDeg[v]++;
        }
    }

    public static ArrayList<Integer>[] transpose(ArrayList<Integer>[] adjList){
        ArrayList<Integer>[] transpose = new ArrayList[adjList.length];
        for(int i=0;i<adjList.length;i++){
            transpose[i] = new ArrayList<>();
        }

        for(int i =0 ;i<adjList.length;i++) {
            for (int child : adjList[i]) {
                transpose[child].add(i);
            }

        }
        return transpose;
    }
}
