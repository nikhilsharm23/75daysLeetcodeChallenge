/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < q.val){
            fun(root , p , q);
        }
        else{
            fun(root , q , p);
        }
        return ans;
    }

    public void fun(TreeNode node , TreeNode p , TreeNode q){
        if(node == null) return;

        if(node == p || node == q){
            ans = node;
            return;
        } 

        if(node.val < p.val){
            fun(node.right , p  , q);
        }
        else if(node.val > q.val){
            fun(node.left , p , q);
        }
        else{
            ans = node;
     
        }

    }
}