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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;
        TreeNode head = new TreeNode(preorder[0]);
        TreeNode ans = head;
        Stack<TreeNode> s = new Stack<>();
        int j = 0;
        for(int i = 1; i < preorder.length; i++) {
            if(head.val != inorder[j]) {
                TreeNode tmp = new TreeNode(preorder[i]);
                head.left = tmp;
                s.push(head);
                head = tmp;
            }else {
                j++;
                while(!s.isEmpty() && s.peek().val == inorder[j]) {
                    head = s.pop();
                    j++;
                    System.out.println(inorder[j]+":"+preorder[i]);
                }
                head.right = new TreeNode(preorder[i]);
                head = head.right;
            }
        }
        return ans;
    }
}
