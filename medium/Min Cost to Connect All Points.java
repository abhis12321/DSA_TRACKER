class Solution {
    private int par[];
    public int minCostConnectPoints(int[][] points) {
        int N = points.length;
        par = new int[N];
        List<edge> edges = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            par[i] = i;
            for(int j = 0; j < N; j++) {
                if(i != j) {
                    int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                    edges.add(new edge(i , j , cost));
                }
            }
        }
        Collections.sort(edges , (a,b) -> a.cost - b.cost);
        int cost = 0;
        for(edge e : edges) {
            int parA = findParent(e.src);
            int parB = findParent(e.dest);
            if(parA != parB) {
                cost += e.cost;
                par[parA] = parB;
            }
        }

        return cost;
    }

    private int findParent(int i) {
        if(par[i] == i) {
            return i;
        }
        return par[i] = findParent(par[i]);
    }
}

class edge {
    int src, dest, cost;
    public edge(int s, int d, int c) {
        this.src = s;
        this.dest = d;
        this.cost = c;
    }
}