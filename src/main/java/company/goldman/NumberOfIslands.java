package company.goldman;

public class NumberOfIslands {
    int[][] neis = {{0,1},{1,0},{0,-1},{-1,0}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean seen[][] = new boolean[m][n];

        int islands = 0;
        for(int i = 0;i<m;i++){
            for(int j =0; j<n;j++){
                if(grid[i][j] == '1' && !seen[i][j]){
                    islands++;
                    dfs(i,j,seen,grid);
                }
            }
        }
        return islands;
    }

    private void dfs(int i, int j ,  boolean[][] seen, char[][] grid){
        seen[i][j] = true;
        for(int[] nei : neis){
            int r = nei[0]+i;
            int c = nei[1]+j;

            if(r>=0&&c>=0&&r<grid.length&&c<grid[0].length&& grid[r][c]=='1' && !seen[r][c])
                dfs(r,c,seen,grid);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},
                {'0','0','1','0','0'},{'0','0','0','1','1'}};
    }
}
