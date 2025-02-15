class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if(n > m) {
            return findMedianSortedArrays(nums2 , nums1);
        }

        int start = 0;
        int end = n;
        int half = (n + m + 1) >> 1;

        while(start <= end) {
            int part1 = (start + end) >> 1;
            int part2 = half - part1;
            int left_a = part1 <= 0 ? Integer.MIN_VALUE : nums1[part1-1];
            int right_a = part1 >= n ? Integer.MAX_VALUE : nums1[part1];
            int left_b = part2 <= 0 ? Integer.MIN_VALUE : nums2[part2-1];
            int right_b = part2 >= m ? Integer.MAX_VALUE : nums2[part2];
            if(left_a > right_b) {
                end = part1 - 1;
            } else if(left_b > right_a) {
                start = part1 + 1;
            } else if(((n + m) & 1) == 1) {
                return Math.max(left_a , left_b);
            } else {
                return ((double)Math.max(left_a , left_b) + Math.min(right_a,right_b)) / 2;
            }
        }

        return 0;
    }
}