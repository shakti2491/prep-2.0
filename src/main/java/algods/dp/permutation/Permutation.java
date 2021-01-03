package algods.dp.permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = new Permutation().permute(nums);
        return;
    }

    private List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        if(nums==null || nums.length==0)
            return result;

        permuteHelper(nums,0,new ArrayList<>());
        return result;
    }

    private void permuteHelper(int[] nums, int start,List<Integer> perm){
        if(start == nums.length){
            result.add(new ArrayList<>(perm));
        }


        for(int i = start; i<nums.length;i++){
            perm.add(nums[i]);
            swap(nums,start,i);
            permuteHelper(nums, start+1,perm);
            swap(nums,start,i);
            perm.remove(perm.size()-1);
        }

    }

    private  void permuteHelper(char[] chars, List<Character> chosen, boolean[] discovered) {

        if (chosen.size() == chars.length) {
            chosen.forEach(System.out::print);
            System.out.println();
        } else {

            for (int i = 0; i < chars.length; i++) {
                // i have chosen a thing
                if (!discovered[i]) {
                    chosen.add(chars[i]);
                    discovered[i] = true;
                    // permute on remaining or explore on remaining
                    permuteHelper(chars, chosen, discovered);
                    // i m putting the  chosen one back for it to be chosen in next permutation
                    chosen.remove(chosen.size()-1);
                    discovered[i] = false;
                }
            }
        }
    }


    private void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
