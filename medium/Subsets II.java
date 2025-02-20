class Solution {
    List<List<Integer>> A;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        A = new ArrayList<>();
        Arrays.sort(nums);
        add(0 , nums , new ArrayList<>());
        return A;
    }

    private void add(int index, int nums[], List<Integer> B) {
        A.add(new ArrayList<>(B));
        for(int i = index; i < nums.length; i++) {
            if(i == index || nums[i] != nums[i-1]) {
                B.add(nums[i]);
                add(i+1 , nums , B);
                B.remove(B.size()-1);
            }
        }
    }
}