class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int degree[] = new int[numCourses];
        List<Integer> map[] = new ArrayList[numCourses];
        for(int pre[] : prerequisites) {
            if(map[pre[1]] == null) {
                map[pre[1]] = new ArrayList<>();
            }
            degree[pre[0]]++;
            map[pre[1]].add(pre[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(degree[i] == 0) {
                q.offer(i);
            }
        }
        
        int ans[] = new int[numCourses], index = 0;
        while(!q.isEmpty()) {
            int a = q.poll();
            ans[index++] = a;
            if(map[a] != null)
            for(int b : map[a]) {
                if(--degree[b] == 0) {
                    q.offer(b);
                }
            }
        }

        if(index == numCourses) {
            return ans;
        }
        return new int[]{};
    }
}