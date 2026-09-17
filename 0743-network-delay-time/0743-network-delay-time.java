import java.util.*;

class Solution {

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        // 1. Create Adjacency List
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // 2. Create Directed Graph
        for (int[] edge : times) {

            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new Pair(v, w));
        }

        // 3. Distance Array
        int[] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        // 4. Min Heap
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.first, b.first)
        );

        pq.offer(new Pair(0, k));

        // 5. Dijkstra
        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int d = curr.first;
            int node = curr.second;

            // Outdated entry
            if (d > dist[node]) {
                continue;
            }

            // Visit neighbours
            for (Pair edge : adj.get(node)) {

                int neigh = edge.first;
                int wt = edge.second;

                int newDist = d + wt;

                // Relaxation
                if (newDist < dist[neigh]) {

                    dist[neigh] = newDist;

                    pq.offer(new Pair(newDist, neigh));
                }
            }
        }

        // 6. Find maximum distance
        int ans = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}