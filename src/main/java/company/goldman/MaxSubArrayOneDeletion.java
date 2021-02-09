package company.goldman;

public class MaxSubArrayOneDeletion {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        if(n==1)
            return arr[0];
        int[] dp1 = new int[n];
        int []dp2 = new int[n];

        dp1[0] = arr[0];
        dp2[n-1]=arr[n-1];
        int res = arr[0];
        for(int i =1;i<n;i++){
            dp1[i] = Math.max(dp1[i-1]+arr[i],arr[i]);
            res = Math.max(res,dp1[i]);
        }

        for(int i =n-2;i>=0;i--){
            dp2[i] = Math.max(dp2[i+1]+arr[i],arr[i]);
        }

        for(int i = 0;i<n;i++){
            if(i==0)
                res = Math.max(res, dp2[i+1]);
            else if(i==n-1)
                res = Math.max(res,dp1[i-1]);
            else
                res = Math.max(res, dp2[i+1]+dp1[i-1]);
        }
        return res;
    }
}
