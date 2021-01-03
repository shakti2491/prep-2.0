package algods.graph.sscs;

import algods.graph.utils.GraphUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class KosaRaju {
    private ArrayList<Integer>[] adjList;
    private int[] inDeg;
    private int[] finishingTime;
    private int count;
    int f =0;
    private List<List<Integer>> sccs;
    private ArrayDeque<Integer> stack;
    public void isSC(int V, int[][] edges){
        adjList = new ArrayList[V];
        this.count = V;
        inDeg = new int[V];
        finishingTime = new int[V];
        stack = new ArrayDeque<>();
        GraphUtils.buildGraph(edges,adjList,inDeg);
        ArrayList<Integer>[] transpose = GraphUtils.transpose(adjList);
        boolean[] seen = new boolean[V];
        for(int i = V-1;i>=0;i--){
            if(!seen[i])
            dfsFill(seen,i,transpose);
        }

        seen = new boolean[V];

        while (!stack.isEmpty()){
            int v = stack.pop();
            if(!seen[v]){
                List<Integer> scc = new ArrayList<>();
                dfs(seen,v,adjList,scc);
                sccs.add(scc);
            }
        }
    }

    private void dfsFill(boolean[] seen, int v,ArrayList<Integer>[] adjList){
        seen[v] = true;
        for(int child : adjList[v]){
            if(!seen[child])
                dfsFill(seen,v,adjList);
        }
        finishingTime[v] = f++;
        stack.push(v);
    }

    private void dfs(boolean[] seen, int v,ArrayList<Integer>[] adjList,List<Integer> scc){
        seen[v] = true;
        scc.add(v);
        for(int child : adjList[v]){
            if(!seen[child])
                dfs(seen,v,adjList,scc);
        }
        finishingTime[v] = f++;
        stack.push(v);
    }
}
