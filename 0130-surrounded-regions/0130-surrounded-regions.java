class Solution {
    static final int[] x = {1, -1, 0, 0};
    static final int[] y = {0, 0, 1, -1};

    private boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }
        return true;
    }

    private void dfs(char[][] a, int n, int m, int i, int j) {
        a[i][j] = '#';

        for (int k = 0; k < 4; k++) {
            int row = i + x[k];
            int col = j + y[k]; // Fixed: j + y[k]

            if (isValid(row, col, n, m) && a[row][col] == 'O') {
                dfs(a, n, m, row, col);
            }
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int n = board.length;
        int m = board[0].length;

        // 1. First Row aur Last Row
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                dfs(board, n, m, 0, j);
            }
            if (board[n - 1][j] == 'O') {
                dfs(board, n, m, n - 1, j);
            }
        }

        // 2. First Column aur Last Column
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                dfs(board, n, m, i, 0); // Fixed: 0 pass hoga
            }
            if (board[i][m - 1] == 'O') {
                dfs(board, n, m, i, m - 1); // Fixed: Last col check added
            }
        }

        // 3. Final conversion
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
}