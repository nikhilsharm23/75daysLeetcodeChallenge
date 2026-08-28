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
    TreeNode prev = null;
    boolean ans = true;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        ans = true;

        fun(root);
        return ans;
    }

    public void fun(TreeNode root){
        if(root == null){
            return;
        }

        fun(root.left);

        if(prev != null){
            if(root.val <= prev.val){
                ans = false;
            }
        }
        prev = root;


        fun(root.right);
    }
}