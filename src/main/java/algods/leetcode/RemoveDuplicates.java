package algods.leetcode;

public class RemoveDuplicates {
    public static void main(String[] args) {
        new RemoveDuplicates().removeDuplicates(new int[]{1,1,2,2,2,3,3});
    }

    public int removeDuplicates(int[] nums) {
        int cur = nums[0];
        int count = 1;
        int EMP = -99999;
        for(int i =1;i<nums.length;i++){
            if(nums[i]==cur && count<2){
                count++;
                continue;
            }
            if(nums[i]==cur && count>2)
                nums[i]= EMP;
            else{
                count = 1;
                cur = nums[i];
            }
        }

        return fillEmpty(nums,EMP);
    }

    private int fillEmpty(int[] nums, int EMP){

        int count = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=EMP)
                nums[count++] = nums[i];
        }
        return count;
    }
}
