package algods.leetcode;

public class MaxAreaIslands {
    int m, n;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int area = 0;
        boolean[][] seen = new boolean[m][n];
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(!seen[i][j] && grid[i][j]==1){
                    area = Math.max(area, area(i,j,seen,grid));
                }
            }
        }
        return area;
    }

    int[][] dirs = {{-1,0},{0,1},{0,-1},{1,0}};
    private int area(int i, int j, boolean[][] seen, int[][] grid){
        seen[i][j] = true;
        int area = 1;

        for(int[] dir : dirs){
            int r = i+dir[0];
            int c = j+dir[1];
            if(r>=0 && c>=0 && r<m&&c<n && !seen[r][c] && grid[r][c]==1){
                area+=area(r,c,seen,grid);
            }
        }
        return area;
    }

    public static void main(String[] args) {
        new MaxAreaIslands().maxAreaOfIsland(new int[][]{
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        });
    }
}
