class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long m : nums) {
            pq.offer(m);
        }

        int opr = 0;
        while(pq.size() > 1 && pq.peek() < k) {
            opr++;
            pq.offer(2 * pq.poll() + pq.poll());
        }

        return opr;
    }
}