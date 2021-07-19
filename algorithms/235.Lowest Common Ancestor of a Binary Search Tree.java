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
        int an=0;
        if(n==p) an|=1;
        if(n==q) an|=2;
        
        if(n.left!=null) an|=dfs(n.left,p,q);
        if(n.right!=null) an|=dfs(n.right,p,q);
        if(an==3 && ans==null) ans=n;
        return an;
    }
}
