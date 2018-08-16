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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root); s2.push(root);
            
        TreeNode right = root;
        TreeNode left = root;
            
        while(!s1.isEmpty() && !s2.isEmpty()) {
            right = s1.pop();
            left = s2.pop();
            
            if(right != null) {
                if(left == null) 
                    return false;
                else if(right.val != left.val) 
                    return false;
            }else {
                if(left != null) 
                    return false;
            }
            
            
            if(right != null) {
                s1.push(right.left);
                s1.push(right.right);
            }
                
            if(left != null) {
                s2.push(left.right);
                s2.push(left.left);
            }
        }
        return true;
    }
}
