package dp.lis;

/**
 *L(i) = 1 + max( L(j) ) where 0 < j < i and arr[j] < arr[i]; or
 * L(i) = 1, if no such j exists.
 */

public class LongestIncreasingSequence {
    public static void main(String[] args) {
        new LongestIncreasingSequence().lengthOfLIS(new int[] {1,3,6,7,9,4,10,4});
    }

    int globalMax = 1;

    public int lengthOfLIS(int[] nums) {
        Integer[] cache = new Integer[nums.length];
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
