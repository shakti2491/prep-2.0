package dp.knapsack01;

public class PartitionSubsetSum {


    public boolean canPartition(int[] arr){
        int sum = 0;
        for(int num: arr)
            sum+=num;
        if(sum%2!=0)
            return false;

        return targetSum(arr, sum/2, arr.length-1);

    }

    private boolean targetSum(int[] arr, int target, int n) {

        if(n<0 || target<0)
            return false;
        if(target == 0)
            return true;

        return targetSum(arr, target-arr[n],n-1) || targetSum(arr, target,n-1);

    }

}
