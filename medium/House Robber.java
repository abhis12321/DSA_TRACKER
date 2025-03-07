class Solution {
    public int rob(int[] nums) {
        int a = nums[0];
        if(nums.length == 1) {
            return a;
        }
        int b = Math.max(nums[0] , nums[1]);
        for(int i=2; i < nums.length; i++) {
            int t = Math.max(a + nums[i] , b);
            a = b;
            b = t;
        }
        return b;
    }
}