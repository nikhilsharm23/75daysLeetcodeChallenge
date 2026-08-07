import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profit, int[] capital) {

        int n = profit.length;

        // Store (capital, profit) pairs
        int[][] projects = new int[n][2];

        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profit[i];
        }

        // Sort by capital
        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));

        // Max Heap for profits
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int idx = 0;

        while (k-- > 0) {

            // Add all projects we can afford
            while (idx < n && projects[idx][0] <= w) {
                pq.offer(projects[idx][1]);
                idx++;
            }

            // No project can be done
            if (pq.isEmpty()) {
                return w;
            }

            // Pick the project with maximum profit
            w += pq.poll();
        }

        return w;
    }
}