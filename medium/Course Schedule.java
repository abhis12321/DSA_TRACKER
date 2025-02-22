class Solution {
    private int N;
    private List<Integer> graph[];
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.N = numCourses;
        graph = new ArrayList[N];

        for(int pre[] : prerequisites) {
            int a = pre[0];
            int b = pre[1];
            if(graph[a] == null) {
                graph[a] = new ArrayList<>();
            }
            graph[a].add(b);
        }

        for(int i = 0; i < N; i++) {
            if(checkLoop(i , new boolean[N])) {
                return false;
            }
        }
        return true;
    }

    private boolean checkLoop(int a, boolean path[]) {
        if(path[a]) {
            return true;
        } else if(graph[a] == null) {
            return false;
        }
        path[a] = true;
        for(int b : graph[a]) {
            if(checkLoop(b , path)) {
                return true;
            }
        }
        graph[a] = null;
        path[a] = false;
        return false;
    }
}