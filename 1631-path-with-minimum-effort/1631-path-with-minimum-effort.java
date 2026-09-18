import java.util.*;

class Solution {

    static class Cell {
        int effort;
        int r;
        int c;

        Cell(int effort, int r, int c) {
            this.effort = effort;
            this.r = r;
            this.c = c;
        }
    }

    private boolean isValid(int r, int c, int n, int m) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int[][] res = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Cell> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.effort, b.effort)
        );

        res[0][0] = 0;
        pq.offer(new Cell(0, 0, 0));

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            Cell curr = pq.poll();

            int dis = curr.effort;
            int row = curr.r;
            int col = curr.c;

            // Destination reached
            if (row == n - 1 && col == m - 1) {
                return dis;
            }

            // Skip outdated entry
            if (dis > res[row][col]) {
                continue;
            }

            for (int k = 0; k < 4; k++) {

                int nr = row + dr[k];
                int nc = col + dc[k];

                if (!isValid(nr, nc, n, m)) {
                    continue;
                }

                int absDiff =
                        Math.abs(
                                heights[row][col]
                                - heights[nr][nc]
                        );

                int newEff =
                        Math.max(dis, absDiff);

                if (newEff < res[nr][nc]) {

                    res[nr][nc] = newEff;

                    pq.offer(
                            new Cell(newEff, nr, nc)
                    );
                }
            }
        }

        return 0;
    }
}