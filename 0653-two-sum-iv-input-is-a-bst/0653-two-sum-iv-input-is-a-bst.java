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
    Stack<TreeNode> asc = new Stack<>();
    Stack<TreeNode> dsc  = new Stack<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }

        TreeNode curr = root;
        while(curr != null){
            asc.push(curr);
            curr = curr.left;
        }

        curr = root;
        while(curr != null){
            dsc.push(curr);
            curr = curr.right;
        }


        TreeNode left = getsmall();
        TreeNode right = getbig();

        while(left != null && right != null && left != right){

            int sum = left.val + right.val;

            if(sum == k){
                return true;
            }

            if(sum < k ){
                left = getsmall();
            }else{
                right = getbig();
            }
        }

        return false;
    }

    public  TreeNode getsmall(){
        if(asc.isEmpty()){
            return null;
        }

        TreeNode small = asc.pop();
        TreeNode curr = small.right;

        while(curr != null){
            asc.push(curr);
            curr = curr.left;
        }
        return small;
    }

    public TreeNode getbig(){
        if(dsc.isEmpty()){
            return null;
        }

        TreeNode big = dsc.pop();
        TreeNode curr = big.left;

        while(curr != null){
            dsc.push(curr);
            curr = curr.right;
        }
        return big;
    }
}