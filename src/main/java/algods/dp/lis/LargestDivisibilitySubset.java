package algods.dp.lis;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *LDS(i) = 1 + max( LDS(j) ) where 0 < j < i and arr[i] % arr[j] == 0; or
 * LDS(i) = 1, if no such j exists.
 */
public class LargestDivisibilitySubset {
    public static void main(String[] args) {
        new LargestDivisibilitySubset().largestDivisibleSubset(new int[]{2,3,5,9,10,12,15,20,27,30,54});
        //Expected
        //[3,9,27,54] size = 4
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        iterativeLDS(nums);
        Arrays.sort(nums);
        Integer[] cache = new Integer[nums.length];
        Integer[] solution = new Integer[nums.length];
        System.out.println(largestDivisibleSubsetSize(nums, nums.length-1,cache,solution));
        return largestDivisibleSubset(solution,nums);
    }

    private List<Integer> largestDivisibleSubset(Integer[] solution,int[] arr) {
        List<Integer> result = new ArrayList<>();
        Integer index = maxIndex;
        while(index!=null){
            result.add(0,arr[index]);
            index = solution[index];
        }
        return result;

    }

    private static int maxIndex = 0;
    private static int globalMax = 1;
    private int largestDivisibleSubsetSize(int[] arr, int index,Integer[] cache, Integer[] solution){
        if(index == 0)
            return 1;
        if(cache[index]!=null)
            return cache[index];
        int max = 1;
        for(int i = 0;i<index;i++){
            int res = largestDivisibleSubsetSize(arr,i,cache,solution);
            if(arr[index]%arr[i] == 0) {
                if(max<res+1){
                    max= res+1;
                    solution[index] = i;
                }
            }
        }
        cache[index] = max;
        if(globalMax<max){
            globalMax = max;
            maxIndex = index;
        }
        return max;
    }


  private List<Integer> iterativeLDS(int[] nums){
    Arrays.sort(nums);
    int[] cache = new int[nums.length];
    int[] sol = new int[nums.length];

        Arrays.fill(cache,1);
        Arrays.fill(sol,-1);
    cache[0] = 1;
    int globalMax = 1;
    int maxIndex = 0;

        for(int i =1;i<nums.length;i++){
        for(int j=0;j<i;j++){
            if(nums[i]%nums[j]==0)
                if(cache[i]<cache[j]+1){
                    cache[i] = cache[j]+1;
                    sol[i] = j;
                }

            if(cache[i]>globalMax){
                globalMax = cache[i];
                maxIndex = i;
            }
        }
    }

    List<Integer> result = getSolution(nums,sol,maxIndex);
        return result;
}

    private List<Integer> getSolution(int[] nums, int[] solution,int maxIndex){

        List<Integer> result = new ArrayList<>();
        int index = maxIndex;
        while(index !=-1){
            result.add(0,nums[index]);
            index = solution[index];
        }

        return result;
    }
}
