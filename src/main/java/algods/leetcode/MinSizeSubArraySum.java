package algods.leetcode;

public class MinSizeSubArraySum {

    public static int minSubArrayLen(int s, int[] nums) {
        int i =0;
        int  j =0;
        int len = Integer.MAX_VALUE;
        int sum = nums[0];
        while(j<nums.length-1){
            if(sum>=s){
                if(i==j)
                    return 1;
                len = Math.min(len,j-i+1);
                sum -= nums[i];
                i++;
            }else{
                j++;
                if(j<nums.length-1)
                    sum+=nums[j];
            }

        }

        return len ==Integer.MAX_VALUE? -1 : len;

    }

    public static void main(String[] args) {
        minSubArrayLen(7,new int[]{2,3,1,2,4,3});
        int a =-1;
        Math.abs(Long.valueOf(a));

    }
}
