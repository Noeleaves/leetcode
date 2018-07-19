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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> list = new LinkedList<>();
        int k = 1;
        list.add(root);
        
        while(list.size() != 0) {
            List<Integer> level = new ArrayList<>(); 
            while(k != 0) {
                TreeNode curr = list.poll();
                level.add(curr.val);
                if(curr.left != null) list.add(curr.left);
                if(curr.right != null) list.add(curr.right);
                k--;
            }
            k = list.size();
            ans.add(level);
        }
        return ans;
    }
}
