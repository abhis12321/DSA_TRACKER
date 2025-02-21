class Solution {
    private int N, M;
    private boolean visited[][];
    private int dirs[][] = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int numIslands(char[][] grid) {
        this.N = grid.length;
        this.M = grid[0].length;
        visited = new boolean[N][M];

        int island = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    island++;
                    visitNeighbour(i, j, grid);
                }
            }
        }

        return island;
    }

    private void visitNeighbour(int i, int j, char grid[][]) {
        if(i < 0 || i >= N || j < 0 || j >= M || visited[i][j] || grid[i][j] == '0') {
            return ;
        }

        visited[i][j] = true;
        for(int offset[] : dirs) {
            visitNeighbour(i+offset[0] , j+offset[1] , grid);
        }
    }
}