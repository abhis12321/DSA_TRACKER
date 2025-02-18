class KthLargest {
    private int K;
    private PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        K = k;
        pq = new PriorityQueue<>();
        for(int m : nums) {
            pq.offer(m);
            if(pq.size() > k) {
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > K) {
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */