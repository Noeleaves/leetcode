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
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        dfsHelper(root, 0);
        return res;
    }
    
    public int dfsHelper(TreeNode root, int height) {
        if(root == null) return height;
        int left = dfsHelper(root.left, height + 1);
        int right = dfsHelper(root.right, height + 1);
        int diff = Math.abs(left - right); 
        res = res && diff <= 1;
        return Math.max(left, right);
    }
}
