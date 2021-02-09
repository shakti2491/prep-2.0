package company.goldman;

import java.util.Arrays;

public class HIndex1 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for(int i = 0;i<citations.length;i++){
            int left = citations.length-i;
            if(citations[i]>=left)
                return left;
        }

        return 0;
    }
}

