package algods.dp.lis;

import java.util.Arrays;

public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b) -> {
            if(a[0]-b[0]!=0)
                return a[0]-b[0];
            else
                return a[1]-b[1];
        });
        helper(envelopes,envelopes.length-1);
        return globalMax;
    }
    int globalMax =1;
    private int helper(int[][] arr, int index){

        if(index == 0)
            return 1;

        int max = 1;
        for(int i =0;i<index;i++){
            int res = helper(arr,i);
            if(arr[index][0]>arr[i][0] && arr[index][1] >arr[i][1]){
                max = Math.max(max,res+1);
            }

        }

        globalMax = Math.max(max,globalMax);
        return max;
    }
}
