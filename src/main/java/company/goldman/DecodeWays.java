package company.goldman;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DecodeWays {
    Map<Integer, Integer> dp = new HashMap<>();
    public int numDecodings(String s) {
        return recursiveWithMemo(0,s);
    }

    private int recursiveWithMemo(int i, String s) {
        if(dp.containsKey(i))
            return dp.get(i);

        if(i==s.length())
            return 1;

        if(s.charAt(i)=='0')
            return 0;
        if(i == s.length()-1)
            return 1;
        int ans = recursiveWithMemo(i+1,s);
        if(Integer.parseInt(s.substring(i,i+2)) <=26){
            ans +=recursiveWithMemo(i+2,s);
        }
        dp.put(i,ans);
        return ans;
    }

    private int bottomUp(String s){
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        return -1;
    }
}
