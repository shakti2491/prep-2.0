package algods.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class DivideArrayKConsecutiveNumbers {

    public static boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        if(nums.length%k!=0)
            return false;

        int n = nums.length/k;
        heap.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        for(int num: nums){
            countMap.put(num, countMap.getOrDefault(num,0)+1);
        }


        for(int i =0;i<k;i++){
            int start = heap.poll();
            countMap.put(start,countMap.get(start)-1);
            for(int j=1;j<n;j++){
                start++;
                if(countMap.containsKey(start) && countMap.get(start)>0 ){
                    countMap.put(start,countMap.get(start)-1);
                    heap.remove(start);
                }else
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isPossibleDivide(new int[]{3,2,1,2,3,4,3,4,5,9,10,11},3);
    }
}
