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
    public boolean isValidSequence(TreeNode root, int[] arr) 
    {
        return exist(root,arr,0);
    }
    
    boolean exist(TreeNode r, int a[], int i)
    {
        if(r==null) return a.length==0;
        if((r.left==null && r.right==null) && (i<a.length && r.val==a[i] && r.val==a[a.length-1])) return true;
        return (i<a.length && (r.val==a[i] && (exist(r.left,a,i+1) || exist(r.right,a,i+1))));
    }
}
