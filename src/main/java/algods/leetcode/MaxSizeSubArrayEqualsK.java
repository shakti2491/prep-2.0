package algods.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxSizeSubArrayEqualsK {
    public static int maxSubArrayLen(int[] nums, int k) {

        Map<Integer,Integer> prefixIndexMap = new HashMap<>();
        int prefix = 0;
        int max = 0;
        int n = nums.length;
        for(int i =0;i<n;i++){
            prefix += nums[i];
            if(prefix==k)
                max = Math.max(i+1,max);

            Integer prev = prefixIndexMap.getOrDefault(prefix-k,-1);
            if(prev!=-1){
                max = Math.max(max,i-prev+1);
            }
            Integer index = prefixIndexMap.getOrDefault(prefix,n);
            prefixIndexMap.put(prefix,Math.min(index,i));
        }
        return max;
    }

    public static void main(String[] args) {
        maxSubArrayLen(new int[]{-2,-1,2,1},1);
    }
}
