package company.goldman;

import lombok.val;

import java.util.*;

public class MinAreaRectangle {
    public int minAreaRect(int[][] points) {
        Map<Integer, List<Integer>> rows = new TreeMap<>();
        for(int[] point : points){
            int x = point[0];
            int y = point[1];
            List<Integer> ys = rows.getOrDefault(x, new ArrayList<>());
            ys.add(y);
        }

        int ans = Integer.MAX_VALUE;
        Map<String, Integer> lastX = new HashMap<>();

        for(int x: rows.keySet()){
            List<Integer> row = rows.get(x);
            Collections.sort(row);
            for(int i =0;i<row.size();i++){
                for(int j = i+1;j<row.size();j++){
                    int y1 = row.get(i), y2 = row.get(j);
                    String code = y1+"#"+y2;
                    if(lastX.containsKey(y1+"#"+y2)){
                        ans = Math.min(ans, (x-lastX.get(code))*(y2-y1));
                    }
                    lastX.put(code,x);
                }
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}
