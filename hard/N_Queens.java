class Solution {
    private int N;
    private char board[][];
    private boolean visitedCols[];
    private final int dirs[][] = new int[][]{{-1,-1} , {-1,1}};
    private List<List<String>> A;
    public List<List<String>> solveNQueens(int n) {
        this.N = n;
        this.board = new char[N][N];
        A = new ArrayList<>();
        visitedCols = new boolean[N];
        for(char row[] : board) {
            Arrays.fill(row , '.');
        }
        recursion(0);
        return A;
    }

    private void recursion(int row) {
        if(row >= N) {
            addBoardAsAns();
            return;
        }

        for(int col = 0; col < N; col++) {
            if(!visitedCols[col]) {
                if(isSafe(row , col , dirs[0]) && isSafe(row , col , dirs[1])) {
                    visitedCols[col] = true;
                    board[row][col] = 'Q';
                    recursion(row+1);
                    board[row][col] = '.';
                    visitedCols[col] = false;
                }
            }
        }
    }

    private boolean isSafe(int i, int j, int dir[]) {
        if(i < 0 || j < 0 || i >= N || j >= N) {
            return true;
        } else if(board[i][j] == 'Q') {
            return false;
        }
        return isSafe(i+dir[0] , j+dir[1], dir);
    }

    private void addBoardAsAns() {
        List<String> B = new ArrayList<>();
        for(char row[] : board) {
            StringBuilder sb = new StringBuilder();
            for(char c : row) {
                sb.append(c);
            }
            B.add(sb.toString());
        }
        A.add(B);
    }
}