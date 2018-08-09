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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0) return null;
        int len = inorder.length;
        TreeNode head = new TreeNode(postorder[len - 1]);
        TreeNode ans = head;
        Stack<TreeNode> s = new Stack<>();
        int j = len - 1;
        
        for(int i = len - 2; i >= 0; i--) {
            if(head.val != inorder[j]) {
                head.right = new TreeNode(postorder[i]);
                s.push(head);
                head = head.right;
            }else {
                j--;
                while(!s.isEmpty() && s.peek().val == inorder[j]) {
                    head = s.pop();
                    j--;
                }
                head.left = new TreeNode(postorder[i]);
                head = head.left;
            }
        } 
        return ans;
    }
}106. Construct Binary Tree from Inorder and Postorder Traversal
