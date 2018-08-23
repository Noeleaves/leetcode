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
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        helper(root);
        return max;
    }
    public int helper(TreeNode root) {
        if(root == null) return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(left + right, max);
        return Math.max(left + 1, right + 1);
    }
}
