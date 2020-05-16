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
    int c=0;
    public int goodNodes(TreeNode root) {
        count(root,root.val);
        return c;
    }
    
    void count(TreeNode n, int max)
    {
        if(n==null) return;
        if(n.val>=max) {max=n.val; c++;}
        count(n.left,max);
        count(n.right,max);
    }    
}
