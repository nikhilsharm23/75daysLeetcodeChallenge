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
    private int idx = 0;
    private Map<Integer ,Integer> inordermap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i = 0; i < inorder.length; i++){
            inordermap.put(inorder[i], i );
        }

        return build(preorder ,  0 , inorder.length - 1);
    }

    private TreeNode  build(int[] preorder , int low , int high){

        if(low > high){
            return null;
        }

        int rootval = preorder[idx++];

        TreeNode root = new TreeNode(rootval);

        int mid  = inordermap.get(rootval);

        root.left = build(preorder , low , mid - 1);

        root.right = build(preorder, mid + 1, high);

        return root;
    }
}