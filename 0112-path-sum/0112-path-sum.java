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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        return fun(root , 0 , targetSum);
    }

    private boolean fun(TreeNode root , int sum , int targetSum){
        if(root == null){
            return false;
        }
        sum += root.val;

        if(root.left == null && root.right == null){ // leaf
            if(sum == targetSum){
                return true;
            }
            return false;
        }
        return fun(root.left , sum , targetSum) ||
        fun(root.right , sum , targetSum);
    }
}