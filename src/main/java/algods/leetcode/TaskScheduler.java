package algods.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b)->b-a);
        for(char task : tasks)
            map.put(task, map.getOrDefault(task,0)+1);
        heap.addAll(map.values());

        int total = 0;
        while(!heap.isEmpty()){
            int count = heap.poll();
            total+=count;
            int space = (count-1)*n;
            total +=space;
            while(!heap.isEmpty() && space!=0){
                int count2 = heap.poll();
                if(count2==count){
                    space -= count2-1;
                    heap.offer(1);
                }else{
                    space -=count2;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        new TaskScheduler().leastInterval(new char[]{
                'A','A','A','B','B','B'},2);
    }
}
