class Solution {
    boolean cycle = false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }


        for(int[] pre:prerequisites){
            int a = pre[0];
            int b = pre[1];
            adj.get(b).add(a);
        }


        boolean[] vis = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for(int i = 0; i <numCourses; i++ ){
            if(!vis[i]){
                dfs(adj , i , path , vis);
            }
        }


        return !cycle;
    }


    public void dfs(List<List<Integer>> a , int node , boolean[] path , boolean[] vis){
        vis[node] = true;
        path[node] = true;


        for(int neigh: a.get(node)){
            if(vis[neigh] && path[neigh]){
                cycle = true;

            }

            if(!vis[neigh]){
                dfs(a , neigh , path , vis);
            }
        } 

        path[node] = false;
    }


}