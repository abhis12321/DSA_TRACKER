class Solution {
    private int M, N;
    private int dp[][];
    private int directions[][] = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int orangesRotting(int[][] grid) {
        M = grid.length;
        N = grid[0].length;
        dp = new int[M][N];
        for(int a[] : dp)  Arrays.fill(a , Integer.MAX_VALUE);

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(grid[i][j] == 2) {
                    dfs(i , j , grid , 0);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0 ; j < N; j++) {
                if(grid[i][j] != 0) {
                    max = Math.max(max , dp[i][j]);
                }
            }
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }

    private void dfs(int i, int j, int grid[][], int d) {
        if(i < 0 || i >= M || j < 0 || j >= N || grid[i][j] == -1 || d >= dp[i][j] || grid[i][j] == 0) {
            return;
        }
        int val = grid[i][j];
        dp[i][j] = d;
        grid[i][j] = -1;
        for(int offset[] : directions) {
            dfs(i+offset[0] , j+offset[1] , grid , d+1);
        }
        grid[i][j] = val;
    }
}