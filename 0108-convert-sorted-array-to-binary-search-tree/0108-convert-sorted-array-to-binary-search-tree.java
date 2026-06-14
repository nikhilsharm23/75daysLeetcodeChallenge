class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int start, int end) {

        // Base case
        if (start > end) {
            return null;
        }

        // Find middle element
        int mid = start + (end - start) / 2;

        // Create root
        TreeNode root = new TreeNode(nums[mid]);

        // Build left subtree
        root.left = buildBST(nums, start, mid - 1);

        // Build right subtree
        root.right = buildBST(nums, mid + 1, end);

        return root;
    }
}