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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans=null;
        dfs(root,p,q);
        return ans;
    }
    
    TreeNode ans;
    int dfs(TreeNode n,TreeNode p,TreeNode q)
    {
        int m=0;
        if(n.left!=null) m|=dfs(n.left,p,q);
        if(n.right!=null) m|=dfs(n.right,p,q);
        
        if(n==p) m|=1;
        if(n==q) m|=2;
        if(m==3 && ans==null) ans=n;
        return m;
    }
}
