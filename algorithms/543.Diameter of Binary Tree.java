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
    int d;
    public int diameterOfBinaryTree(TreeNode root) {
     d=0;
        height(root);
        return d;
    }
    
    public int height(TreeNode x)
    {
        if(x==null) return 0;
        int l=height(x.left),r=height(x.right);
        if(l+r>d) d=l+r;
        return 1+Math.max(l,r);
    }
}
