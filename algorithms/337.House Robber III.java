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
    public int rob(TreeNode root) {
        int res[]=robsub(root);
        return Math.max(res[0],res[1]);
    }
    
    int[] robsub(TreeNode root)
    {
        if(root==null) return new int[2];
        int left[]=robsub(root.left),right[]=robsub(root.right);
        int res[]=new int[2];
        res[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        res[1]=root.val+left[0]+right[0];
        return res;
    }
}
