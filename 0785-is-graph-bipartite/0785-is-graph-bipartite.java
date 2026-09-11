class Solution {
    private boolean res = true;

    private void dfs(int[][] graph , int node , int c , int[]colors){
        colors[node] = c;

        for(int i = 0; i < graph[node].length; i++){
            int neigh = graph[node][i];

            if(colors[neigh] != -1 && colors[neigh] == c){
                res = false;
                return;
            }

            if(colors[neigh] == -1){
                dfs(graph , neigh, 1-c , colors);
            }
        }
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors,-1);
        res = true;


        for(int i = 0; i < n; i++){
            if(colors[i] == -1){
                dfs(graph , i , 0 , colors);
            }
        }

        return res;
    }
}