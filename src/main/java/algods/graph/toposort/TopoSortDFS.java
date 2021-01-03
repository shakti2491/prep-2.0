package algods.graph.toposort;

import algods.graph.utils.GraphUtils;

import java.util.ArrayList;

public class TopoSortDFS {
    ArrayList<Integer>[] adjList;
    int[] order;
    int[] inDeg;
    int count;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // check cycle first
        count = numCourses;
        adjList = new ArrayList[numCourses];
        order = new int[numCourses];
        inDeg = new int[numCourses];
        boolean[] seen = new boolean[numCourses];
        GraphUtils.buildGraph(prerequisites,adjList,inDeg);

        for(int i=0;i<numCourses;i++){
            if(!seen[i])
                dfs(seen,i);
        }

        return order;
    }


    private void dfs(boolean[] visited, int cur){
        visited[cur] = true;
        for(int child : adjList[cur]){
            if(!visited[child])
                dfs(visited, child);
        }
        order[cur] = count--;
    }
}
