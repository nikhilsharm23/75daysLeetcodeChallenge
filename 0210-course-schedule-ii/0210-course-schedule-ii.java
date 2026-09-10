class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        // graph 
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        int [] indegree = new int[numCourses];

        for(int[] pre : prerequisites){
            int course = pre[0];
            int prerequisite = pre[1];


            graph.get(prerequisite).add(course);

            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int ans[] = new int[numCourses];
        int index = 0;

        while(!q.isEmpty()){
            int curr = q.poll();

            ans[index++] = curr;

            for(int neighbour : graph.get(curr)){
                indegree[neighbour]--;

                if(indegree[neighbour] == 0){
                    q.offer(neighbour);
                }
            }
        }

        if(index != numCourses) {
            return new int[0];
        }

        return ans;
    }
}