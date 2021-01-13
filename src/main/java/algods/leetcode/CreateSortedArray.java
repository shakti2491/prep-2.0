package algods.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class CreateSortedArray {
    public static void main(String[] args) {
        createSortedArray(new int[]{1,3,3,3,2,4,2,1,2});
    }
    public static int createSortedArray(int[] instructions) {

        TreeMap<Integer,Integer> map = new TreeMap<>();

        int cost = 0;


        for(int i : instructions){
            Map<Integer,Integer> aMap = map.headMap(i);
            Map<Integer,Integer> bMap = map.tailMap(i);
            int a=0,b=0;
            for(Integer val : aMap.values())
                a +=val;
            for(Integer val: bMap.values())
                b +=val;

            cost+=Math.min(a,b);
            map.put(i,map.getOrDefault(i,0)+1);
        }

        return cost;
    }
}
