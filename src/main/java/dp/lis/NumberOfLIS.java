package dp.lis;

import java.util.Arrays;

public class NumberOfLIS {
    public static void main(String[] args) {
        new NumberOfLIS().findNumberOfLIS(new int[] {1,2,4,3,5,4,7,2});
    }

    public int findNumberOfLIS(int[] nums) {
        if(nums== null || nums.length==0)
            return 0;
        if(nums.length==1)
            return 1;

        return countLIS(nums);
    }

    private int countLIS(int[] nums){
        int[] cache = new int[nums.length];
        int[] counts = new int[nums.length];
        Arrays.fill(cache,1);
        Arrays.fill(counts,1);
        int globalMax = 1;
        for(int i=1;i<nums.length;i++){
            for(int j =0;j<i;j++ ){
                if(nums[i]>nums[j]){
                    if(cache[i] == cache[j]+1)
                        counts[i] += counts[j];
                    else if(cache[i] < cache[j]+1){
                        cache[i] = cache[j]+1;
                        counts[i] = counts[j];
                    }
                }
            }
            globalMax = Math.max(cache[i],globalMax);
        }

        int total = 0;
        for(int i =0;i<nums.length;i++){
            if(cache[i] == globalMax){
                total +=counts[i];
            }
        }
        return total;
    }
}
