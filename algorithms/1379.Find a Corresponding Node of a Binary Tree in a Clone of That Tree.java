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
    public final TreeNode getTargetCopy(final TreeNode o, final TreeNode c, final TreeNode t) 
    {
        if(o==t) return c;
        if(o.left!=null)
        {
            TreeNode l=getTargetCopy(o.left,c.left,t);
            if(l!=null) return l;
        }
        if(o.right!=null)
        {
            TreeNode r=getTargetCopy(o.right,c.right,t);
            if(r!=null) return r;
        }
        return null;
    }
}
