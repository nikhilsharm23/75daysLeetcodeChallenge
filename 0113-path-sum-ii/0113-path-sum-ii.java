/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetsum) {
        List<List<Integer>> res = new ArrayList<>();
        fun(root, 0, targetsum, new ArrayList<>(), res);
        return res;
    }

    public void fun(TreeNode root , int sum , int targetsum, List<Integer> path , List<List<Integer>> res){
        if(root == null){
            return;
        }

        sum += root.val;
        path.add(root.val);

        if(root.left == null && root.right == null){
           if(sum == targetsum){
            res.add(new ArrayList<>(path));
           }
           path.remove(path.size() - 1);
           return;
        }

        fun(root.left , sum , targetsum , path , res);
        fun(root.right, sum, targetsum, path, res);

        path.remove(path.size() - 1);
    }
}