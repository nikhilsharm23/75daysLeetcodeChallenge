class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(candidates , target , 0 , new ArrayList<>(), res);

        return res;
    }


    private void backtrack(int[] candidates , int target , int idx , List<Integer> curr , List<List<Integer>> res){
        //Base case 

        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(idx == candidates.length || target < 0){
            return;
        }


        backtrack(candidates , target , idx+1 , curr , res);
        curr.add(candidates[idx]);

        backtrack(candidates , target - candidates[idx] , idx , curr , res);

        curr.remove(curr.size() - 1);

    }
}