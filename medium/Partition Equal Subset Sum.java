class Solution {
    public boolean canPartition(int[] nums) {
        int sum = sum(nums);
        if((sum & 1) == 1) {
            return false;
        }

        int half = sum / 2;
        boolean dp[] = new boolean[half + 1];
        
        dp[0] = true;

        for(int m : nums) {
            if(m <= half) {
                for(int j = half; j >= m; j--) {
                    if(dp[j-m]) {
                        dp[j] = true;
                    }
                }
                dp[m] = true;
            } else {
                return false;
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[half];
    }

    private int sum(int nums[])  {
        int sum = 0;
        for(int m : nums) {
            sum += m;
        }
        return sum;
    }
}