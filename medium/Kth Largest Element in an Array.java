class Solution {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();

        // for(int m : nums) {
        //     pq.offer(m);
        //     if(pq.size() > k) {
        //         pq.poll();
        //     }
        // }
    
        // return pq.peek();
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}