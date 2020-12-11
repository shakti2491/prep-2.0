package dp.lis;

/**
 *L(i) = 1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or
 * L(i) = 1, if no such j exists.
 */

public class LongestIncreasingSequence {
    public static void main(String[] args) {
        new LongestIncreasingSequence().lengthOfLIS(new int[] {1,2,4,3,5,4,7,2});
    }

    int globalMax = 1;

    public int lengthOfLIS(int[] nums) {
        Integer[] cache = new Integer[nums.length];
        lengthOfLIS(nums, nums.length -1,cache);
        return globalMax;
    }

    //recursive
    /**
     *L(i) = 1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or
     * L(i) = 1, if no such j exists.
     */
    int lengthOfLIS(int[] arr, int index, Integer[] cache){
        if(index == 0)
            return 1;

        if(cache[index]!=null)
            return cache[index];

        int max = 1;
        for(int i = 0; i<index;i++){
            int res = lengthOfLIS(arr,i,cache);
            if(arr[index]>arr[i]) {

                max = Math.max(max, res + 1);
            }
        }
        cache[index] = max;
        globalMax = Math.max(max,globalMax);
        return max;
    }
}
