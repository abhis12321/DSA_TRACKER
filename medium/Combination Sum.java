class Solution {
    private List<List<Integer>> A;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        A = new ArrayList<>();
        checkSum(0 , target , candidates , new ArrayList<>());
        return A;
    }
    private void checkSum(int i, int sum, int arr[], List<Integer> B) {
        if(sum == 0) {
            A.add(new ArrayList<>(B));
            return ;
        } else if(sum < 0 || i >= arr.length) {
            return ;
        }
        checkSum(i+1 , sum , arr , B);
        B.add(arr[i]);
        checkSum(i , sum-arr[i] , arr , B);
        B.remove(B.size()-1);
    }
}