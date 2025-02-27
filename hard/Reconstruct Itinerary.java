class Solution {
    private List<String> path = new ArrayList<>();
    private Map<String,List<String>> map = new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        // Collections.sort(tickets , (a , b) -> a.get(1).compareTo(b.get(1)));
        for(List<String> ticket : tickets) {
            String u = ticket.get(0);
            String v = ticket.get(1);
            if(!map.containsKey(u)) {
                map.put(u , new ArrayList<>());
            }
            map.get(u).add(v);
        }

        for(List<String> neighbors : map.values()) {
            Collections.sort(neighbors);
        }
        dfs("JFK");
        return path;
    }

    private void dfs(String curr) {
        List<String> neighbors = map.getOrDefault(curr , new ArrayList<>());
        while(!neighbors.isEmpty()) {
            String next = neighbors.remove(0);
            dfs(next);
        }
        path.add(0 , curr);
    }
}