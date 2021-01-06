package algods.graph.sssp.dijkstra;

import java.util.*;

public class Dijkstra {

    // directed graph with weights
    private ArrayList<int[]>[] graph;
    private Map<Integer,Integer> dScore;
    private PriorityQueue<Integer> heap;
    private Set<Integer> settled;
    public int dijkstra(int[][] edges, int N, int K) {
        buildGraph(edges,N);
        init(K,N);

        while(settled.size()!=N){
            Integer node = heap.poll();
            settled.add(node);
            updateDijkstraScore(node);
        }

        int ans = 0;
        for(int val: dScore.values()){
            if(val==Integer.MAX_VALUE)
                return -1;
            ans = Math.max(ans,val);
        }
        return ans;

    }

    private void updateDijkstraScore(Integer node){

        for(int[] child: graph[node]){
            if(!settled.contains(child)){
                int w = child[1];
                int v = child[0];
                int newDistance = dScore.get(node)+w;
                if(newDistance < dScore.get(v)){
                    dScore.put(v,newDistance);
                    heap.remove(v);
                    heap.offer(v);
                }

            }

        }

    }

    private void buildGraph(int[][] edges, int N){
        graph =  new ArrayList[N];
        for(int i=0;i<N;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph[u].add(new int[]{v,w});
        }

    }
    private void init(int source, int N){
        dScore = new HashMap<>();
        heap = new PriorityQueue<>(N,(a,b)->dScore.get(a)-dScore.get(b));
        settled = new HashSet<>();
        for(int i =0;i<N;i++){
            if(i!=source){
                dScore.put(i,Integer.MAX_VALUE);
                heap.offer(i);
            }
        }
        dScore.put(source,0);
        heap.offer(source);
    }

    public static void main(String[] args) {
        new Dijkstra().dijkstra(new int[][]{{2,1,1},{2,3,1},{3,4,1}},4,2);
    }
}
