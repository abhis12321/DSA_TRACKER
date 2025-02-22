class Solution {
    private int N, M;
    public int maxAreaOfIsland(int[][] grid) {
        this.N = grid.length;
        this.M = grid[0].length;
        int maxArea = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int area = dfs(i , j , grid);
                maxArea = Math.max(maxArea , area);
            }
        }
        return maxArea;
    }
    private int dirs[][] = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
    private int dfs(int i, int j, int grid[][]) {
        if(i < 0 || i >= N || j < 0 || j >= M || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int islands = 0;
        for(int offset[] : dirs) {
            islands += dfs(i+offset[0] , j+offset[1] , grid);
        }
        return islands+1;
    }
}