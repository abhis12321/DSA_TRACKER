class Solution {
    private boolean isCyclic;
    private ArrayList<Integer> graph[];
    private int ans[], visited[], index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        index = numCourses-1;
        ans = new int[numCourses];
        visited = new int[numCourses];
        graph = new ArrayList[numCourses];

        for(int pre[] : prerequisites) {
            if(graph[pre[1]] == null) {
                graph[pre[1]] = new ArrayList<>();
            }
            graph[pre[1]].add(pre[0]);
        }

        for(int i = 0; i < numCourses && !this.isCyclic; i++) {
            dfs(i);
        }

        return  this.isCyclic ? new int[]{} : ans;
    }

    private void dfs(int curr) {
        // System.out.println(curr + " " + graph[curr]);
        if(visited[curr] == 2 || this.isCyclic) {
            return ;
        } else if(visited[curr] == 1) {
            this.isCyclic = true;
            return ;
        }
        visited[curr] = 1;
        if(graph[curr] != null)
        for(int neighbor : graph[curr]) {
            dfs(neighbor);
        }
        ans[index--] = curr;
        visited[curr] = 2;
    }

}