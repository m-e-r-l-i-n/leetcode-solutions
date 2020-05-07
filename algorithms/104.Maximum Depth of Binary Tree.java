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
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        else return depth(root,0);  
    }
    
    public int depth(TreeNode x,int n)
    {
        if(x==null) return n;
        else return Math.max(depth(x.left,n+1),depth(x.right,n+1));
    }
}
