package algods.leetcode;

public class PathWithMaxGold {

    private int N;
    private int M;
    private int[][] grid;
    private int max = 0;
    public int getMaximumGold(int[][] grid) {

        this.grid = grid;
        M = grid.length;
        N = grid[0].length;
        boolean[][] seen = new boolean[M][N];

        for(int i =0;i<M;i++)
            for(int j=0;j<N;j++){
                if(grid[i][j]!=0){
                    backtrack(i,j,seen,grid[i][j]);
                }
            }
        return max;
    }

    private int [][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
    private void backtrack(int i, int j, boolean visited[][] , int sum){
        visited[i][j]= true;
        for(int[] dir : dirs ){
            int x= i +dir[0];
            int y= j+dir[1];
            if(isSafe(x,y) && !visited[x][y])
                backtrack(x,y,visited,sum+grid[x][y]);
        }
        visited[i][j] = false;
        max = Math.max(max,sum);

    }

    private boolean isSafe(int x,int y){
        if(x>=0 && x<M && y>=0 && y<N && grid[x][y]!=0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,6,0},
        {5,8,7},
        {0,9,0}};
        new PathWithMaxGold().getMaximumGold(grid);
    }
}
