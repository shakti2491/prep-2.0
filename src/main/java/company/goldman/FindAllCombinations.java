package company.goldman;

import java.util.ArrayList;
import java.util.List;

public class FindAllCombinations {

    public static List<List<Integer>> combinations(int[] nums){
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for(int i =0; i< (1<<n);i++){
            List<Integer> res = new ArrayList<>();
            for(int j =0; j<nums.length;j++){
                if((i&(1<<j))!=0){
                    res.add(nums[j]);
                }
            }
            result.add(res);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = combinations(new int[] {5,6,9});
        System.out.println(ans);
    }

}
