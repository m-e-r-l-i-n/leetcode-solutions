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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(height(root,x)==height(root,y) && parent(root,x)!=parent(root,y)) return true;
        else return false;
    }
    
    int height(TreeNode n,int x)
    {
        if(n==null) return Integer.MIN_VALUE;
        if(n.val==x) return 1;
        int l=height(n.left,x),r=height(n.right,x);
        return 1+Math.max(l,r);
    }
    
    TreeNode parent(TreeNode n,int x)
    {
        if(n==null) return null;
        if((n.left!=null && n.left.val==x) || (n.right!=null && n.right.val==x)) return n;
        TreeNode l=parent(n.left,x);
        if(l!=null) return l;
        return parent(n.right,x);
    }
}
