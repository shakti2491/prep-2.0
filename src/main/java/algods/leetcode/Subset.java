package algods.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subset {

    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        Integer a = map.get(1);

        new Subset().partition("aab");
    }
    private List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();

        List<String> bitMasks = bitMaskList(s.length()-1);

        for(String bitMask: bitMasks){
            boolean flag = true;
            List<String> subs = sub(s,bitMask);
            List<String> res = new ArrayList<>();
            for(String sub: subs){
                if(isPalindrome(sub))
                    res.add(sub);
                else{
                    flag = false;
                    break;
                }
            }
            if(flag)
            result.add(res);

        }


        return result;
    }

    private List<String> sub(String str, String bitMask){
        List<String> result = new ArrayList<>();
        int start = 0;

        for(int i =0;i<bitMask.length();i++){
            if(bitMask.charAt(i)=='1'){
                result.add(str.substring(start,i+1));
                start = i+1;
            }
        }

        result.add(str.substring(start));
        return result;
    }

    private boolean isPalindrome(String str){
        int i = 0;
        int j = str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }
    private List<String> bitMaskList(int n){

        int i = (int)Math.pow(2,n);
        int max = (int)Math.pow(2,n+1);
        List<String> result = new ArrayList<>();
        for(;i<max;i++){
            String bitMask = Integer.toBinaryString(i).substring(1);
            result.add(bitMask);
        }
        return result;
    }
}
