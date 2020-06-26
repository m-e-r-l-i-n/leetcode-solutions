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
    public int sumNumbers(TreeNode root) {
        return total(root, 0);
    }
    
    int total(TreeNode n, int sum)
    {
        if(n==null) return 0;
        if(n.left==null && n.right==null) return 10*sum+n.val;
        return total(n.left,10*sum+n.val)+total(n.right,10*sum+n.val);
    }
}
