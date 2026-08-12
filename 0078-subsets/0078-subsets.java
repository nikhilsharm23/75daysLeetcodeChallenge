import java.util.*;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        fun(nums, 0, ans, tmp);

        return ans;
    }

    private void fun(int[] nums, int idx,
                     List<List<Integer>> ans,
                     List<Integer> tmp) {

        // Base case
        if (idx == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        // Element nahi lenge
        fun(nums, idx + 1, ans, tmp);

        // Element lenge
        tmp.add(nums[idx]);

        fun(nums, idx + 1, ans, tmp);

        // Backtracking
        tmp.remove(tmp.size() - 1);
    }
}