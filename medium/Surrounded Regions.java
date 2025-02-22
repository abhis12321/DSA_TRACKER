class Solution {
    private int directions[][] = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++) {
            trackNotAllowed(i , 0, board);
            trackNotAllowed(i , n-1, board);
        }

        for(int j = 0; j < n; j++) {
            trackNotAllowed(0, j, board);
            trackNotAllowed(m-1, j, board);
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void trackNotAllowed(int i, int j, char board[][]) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#';
        for(int offset[] : directions) {
            trackNotAllowed(i+offset[0] , j+offset[1] , board);
        }
    }
}