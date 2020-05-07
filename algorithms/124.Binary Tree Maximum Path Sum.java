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
class Solution 
{
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) 
    {
        recur(root);
        return max;
    }
    
    int recur(TreeNode root) 
    {
        if(root==null) return 0;
        int l=Math.max(recur(root.left),0);
        int r=Math.max(recur(root.right),0);
        max=Math.max(max,root.val+l+r);
        return root.val+Math.max(l,r);
    }
}
