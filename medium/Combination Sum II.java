class Solution {
    private List<List<Integer>> A;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        A = new ArrayList<>();
        Arrays.sort(candidates);
        perm(0 , target, candidates, new ArrayList<>());
        return A;
    }
    private void perm(int currIndex, int target, int nums[], List<Integer> B) {
        if(target == 0) {
            A.add(new ArrayList<>(B));
            return ;
        } else if(target < 0) {
            return;
        }

        for(int i = currIndex; i < nums.length; i++) {
            if(i == currIndex || nums[i] != nums[i-1]) {
                B.add(nums[i]);
                perm(i+1, target-nums[i], nums, B);
                B.remove(B.size() - 1);
            }
        }
    }
}