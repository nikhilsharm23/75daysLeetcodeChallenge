import java.util.*;

class Solution {

    static class Cell {

        int times;
        int r;
        int c;

        Cell(int times, int r, int c) {
            this.times = times;
            this.r = r;
            this.c = c;
        }
    }


    private boolean isValid(int r, int c, int n) {

        return r >= 0 && r < n && c >= 0 && c < n;
    }


    public int swimInWater(int[][] grid) {

        int n = grid.length;

        int[][] res = new int[n][n];

        // Sabhi cells ko infinity
        for (int i = 0; i < n; i++) {
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }


        // Min Heap
        PriorityQueue<Cell> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.times, b.times)
        );


        // Starting cell
        res[0][0] = grid[0][0];

        pq.offer(new Cell(grid[0][0], 0, 0));


        // Down, Up, Left, Right
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, -1, 1};


        while (!pq.isEmpty()) {

            Cell curr = pq.poll();

            int time = curr.times;
            int row = curr.r;
            int col = curr.c;


            // Destination
            if (row == n - 1 && col == n - 1) {
                return time;
            }


            if (time > res[row][col]) {
                continue;
            }


            // 4 directions
            for (int k = 0; k < 4; k++) {

                int r = row + dr[k];
                int c = col + dc[k];


               
                if (!isValid(r, c, n)) {
                    continue;
                }


             
                int newtime = Math.max(time, grid[r][c]);


                // Agar better time mila
                if (newtime < res[r][c]) {

                    // Distance update
                    res[r][c] = newtime;

                    pq.offer(new Cell(newtime, r, c));
                }
            }
        }


        return res[n - 1][n - 1];
    }
}