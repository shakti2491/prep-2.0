package graph.toposort;

import graph.utils.GraphUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class TopoSortBFS {
    ArrayList<Integer>[] adjList;
    int[] order;
    int[] inDeg;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // check cycle first
        adjList = new ArrayList[numCourses];
        order = new int[numCourses];
        inDeg = new int[numCourses];
        GraphUtils.buildGraph(prerequisites,adjList,inDeg);
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(inDeg[i]==0)
                q.add(i);
        }

        int i =0;
        while(!q.isEmpty()){
            int vertex = q.poll();
            order[i++] = vertex;
            for(int child: adjList[vertex]){
                inDeg[child]--;
                if(inDeg[child]==0)
                    q.offer(child);

            }
        }

        if(i<numCourses)
            return new int[0];


        return order;
    }
}
