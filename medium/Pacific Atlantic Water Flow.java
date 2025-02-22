class Solution {
    private int N, M;
    private boolean[][] pacific, atlantic;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.N = heights.length;
        this.M = heights[0].length;
        pacific = new boolean[N][M];
        atlantic = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            dfs(i, 0, heights, pacific, heights[i][0]);
            dfs(i, M-1, heights, atlantic, heights[i][M-1]);
        }

        for(int j = 0; j < M; j++) {
            dfs(0 , j , heights, pacific, heights[0][j]);
            dfs(N-1, j, heights, atlantic, heights[N-1][j]);
        }

        List<List<Integer>> A = new ArrayList<>();
        List<Integer> B;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(atlantic[i][j] && pacific[i][j]) {
                    B = new ArrayList<>();
                    B.add(i);
                    B.add(j);
                    A.add(B);
                }
            }
        }

        return A;
    }
    private void dfs(int i, int j, int heights[][], boolean flow[][], int prev) {
        if(i < 0 || j < 0 || i >= N || j >= M || flow[i][j] || heights[i][j] < prev) {
            return;
        }
        flow[i][j] = true;
        int val = heights[i][j];
        heights[i][j] = prev + 1;

        dfs(i-1, j, heights, flow, val);
        dfs(i+1, j, heights, flow, val);
        dfs(i, j-1, heights, flow, val);
        dfs(i, j+1, heights, flow, val);
        heights[i][j] = val;
    }
}