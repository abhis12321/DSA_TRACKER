class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) {
        int n1 = maxHeap.size();
        int n2 = minHeap.size();
        maxHeap.offer(num);
        if(n2 > 0) {
            maxHeap.offer(minHeap.poll());
        }
        while(maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        int n = minHeap.size() + maxHeap.size();
        System.out.println(maxHeap + " " + minHeap);
        if(n % 2 == 0) {
            return n == 0 ? -1 : (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */