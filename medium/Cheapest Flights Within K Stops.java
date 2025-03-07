class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int cost[] = new int[n];
        Arrays.fill(cost , Integer.MAX_VALUE);
        cost[src] = 0;

        // for(int i = 0; i <= k; i++) {
        //     int prev[] = cost.clone();
        //     for(int flight[] : flights) {
        //         int u = flight[0];
        //         int v = flight[1];
        //         int flight_cost = flight[2];
        //         if(prev[u] != Integer.MAX_VALUE && prev[u] + flight_cost < cost[v]) {
        //             cost[v] = prev[u] + flight_cost;
        //         }
        //     }
        // }

        ArrayList<int[]> graph[] = new ArrayList[n];
        for(int i = 0; i < n; i++)  graph[i] = new ArrayList<>();

        for(int flight[] : flights) {
            graph[flight[0]].add(new int[]{flight[1] , flight[2]});
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src , 0 , 0});
        
        while(!q.isEmpty()) {
            int u = q.peek()[0];
            int K = q.peek()[1];
            int curr_cost = q.poll()[2];
            if(K <= k) {
                K++;
                for(int neighbor[] : graph[u]) {
                    int v = neighbor[0];
                    int flight_cost = neighbor[1];
                    if(curr_cost + flight_cost < cost[v]) {
                        cost[v] = curr_cost + flight_cost;
                        q.offer(new int[]{v , K , cost[v]});
                    }
                }
            }
        }

        // System.out.println(Arrays.toString(cost));
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}