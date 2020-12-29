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
    int mask=0;
    public int pseudoPalindromicPaths (TreeNode n) {
        mask^=1<<n.val;
        int c=0;
        if(n.left==null && n.right==null) c+=palin(mask)?1:0;
        if(n.left!=null) c+=pseudoPalindromicPaths(n.left);
        if(n.right!=null) c+=pseudoPalindromicPaths(n.right);
        mask^=1<<n.val;
        return c;
    }
    
    boolean palin(int n)
    {
        int o=0;
        while(n>0)
        {
            if(n%2==1) o++;
            n/=2;
        }
        return o<2;
    }
}
