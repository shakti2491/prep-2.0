package algods.leetcode;

import java.util.Arrays;

public class KnightProbability {
    public static double knightProbability(int N, int K, int r, int c) {
        double[][] temp = new double[N][N];
        temp[r][c] = 1;
        int[][] dirs = {{-1,-2},{-2,-1},{-1,2},{-2,1},{1,2},{2,1},{2,-1},{1,-2}};
        for(int k=1;k<=K;k++){
            double[][] dp = new double[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    for(int[] dir: dirs){
                        int x = i+dir[0];
                        int y = j+dir[1];
                        if(x>=0 && y>=0 && x<N && y<N){
                            dp[i][j] +=temp[x][y]/8.0;
                        }
                    }
                }
            }
            temp = dp;
        }
        double total = 0;
        for(int i =0;i<N;i++){
            for(int j=0;j<N;j++){
                total +=temp[i][j];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        knightProbability(8,30,6,4);
    }
}
