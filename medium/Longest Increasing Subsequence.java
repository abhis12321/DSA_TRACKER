class Solution {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        int dp[] = new int[N];
        Arrays.fill(dp , 1);

        for(int i = N-1; i > 0; i--) {
            for(int j = i-1; j >= 0; j--) {
                if(nums[i] > nums[j]) {
                    dp[j] = Math.max(dp[j] , dp[i]+1);
                }
            }
        }

        return getMax(dp);
    }

    private int getMax(int dp[]) {
        int max = 0;
        for(int m : dp) {
            max = Math.max(max , m);
        }
        return max;
    }
}