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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return recur(p,q,true);
    }
    
    boolean recur(TreeNode a,TreeNode b,boolean ans)
    {
        if(a==null && b==null) return ans&true;
        if((a==null && b!=null) || (a!=null && b==null)) return false;
        if(a.val!=b.val) return false;
        return (ans&recur(a.left,b.left,ans))&recur(a.right,b.right,ans);
    }
}
