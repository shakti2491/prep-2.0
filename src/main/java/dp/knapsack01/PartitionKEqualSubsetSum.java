package dp.knapsack01;

import java.util.Arrays;
import java.util.List;

//https://www.youtube.com/watch?v=DB-9JlnbBpM
public class PartitionKEqualSubsetSum {



    static boolean partition(int[] arr, int i, int[] target, List<List<Integer>> p ){
        int value = arr[i];
        for(int k=0;k<target.length && i< arr.length ;k++){
            if(target[k]>=value){
                target[k] -=value;
                if(partition(arr,i+1,target,p)){
                    p.get(k).add(value);
                    break;
                }else{
                    target[k] +=value;
                }
            }
        }
        return Arrays.stream(target).sum() == 0;
    }

}
