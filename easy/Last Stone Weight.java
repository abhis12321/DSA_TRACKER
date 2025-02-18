class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq =  new PriorityQueue<>((a , b) -> b - a);
        for(int stone : stones) {
            pq.offer(stone);
        }

        while(pq.size() > 1) {
            int w1 = pq.poll();
            int w2 = pq.poll();
            if(w1 > w2) {
                pq.offer(w1 - w2);
            }
        }
        pq.offer(0);
        return pq.peek();
    }
}