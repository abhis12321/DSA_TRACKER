class Solution {
    private int N;
    private boolean[][] visited;
    public int swimInWater(int[][] grid) {
        this.N = grid.length;
        int[] min_max = getMinMax(grid);
        int low = min_max[0];
        int high = min_max[1];

        while(low < high) {
            int mid = (low + high) / 2;
            this.visited = new boolean[N][N];
            boolean ok = isPossibleToSwim(0 , 0 , grid , mid);
            if(ok) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(Arrays.toString(min_max));
        return low;
    }

    private int[] getMinMax(int grid[][]) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int row[] : grid) {
            for(int m : row) {
                min = Math.min(min , m);
                max = Math.max(max , m);
            }
        }

        return new int[]{min , max};
    }
    
    private boolean isPossibleToSwim(int i, int j, int grid[][], int t) {
        if(i < 0 || j < 0 || i >= N || j >= N || visited[i][j] || grid[i][j] > t) {
            return false;
        } else if(i == N-1 && j == N-1) {
            return true;
        }
        visited[i][j] = true;
        boolean left = isPossibleToSwim(i , j-1 , grid , t);
        boolean right = isPossibleToSwim(i , j+1 , grid , t);
        boolean up = isPossibleToSwim(i-1 , j , grid , t);
        boolean down = isPossibleToSwim(i+1 , j , grid , t);
        return left || right || up || down;
    }
}