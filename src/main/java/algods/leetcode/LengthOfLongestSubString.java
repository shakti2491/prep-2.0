package algods.leetcode;

import java.util.Arrays;

public class LengthOfLongestSubString {
    public static void main(String[] args) {
        new LengthOfLongestSubString().lengthOfLongestSubstring("pwwkew");
    }
    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[128];
        Arrays.fill(index,-1);
        int i = 0,j = 1;
        index[s.charAt(i)] = i;
        int max = -1;
        while(j<s.length()){
            char c = s.charAt(j);
            max = Math.max(max,j-i);
            if(index[c]!=-1){
                if(index[c]>=i){
                    i = index[c]+1;
                }
            }
            index[c] = j;
            j++;

        }
        max = Math.max(max,j-i);
        return max;

    }
}
