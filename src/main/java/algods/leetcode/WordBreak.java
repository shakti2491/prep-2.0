package algods.leetcode;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    List<String> list;
    public boolean wordBreak(String s, List<String> wordDict) {
        list = wordDict;
        return helper(s,0);
    }


    private boolean helper(String s,int index){
        if(index == s.length())
            return true;
        for(int i = index;i<s.length();i++){

            String str = s.substring(index,i+1);
            if(list.contains(str) && helper(s,i))
                return true;

        }

        return false;
    }

    public static void main(String[] args) {
        new WordBreak().wordBreak("leetcode", Arrays.asList("leet","code"));
    }
}
