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
    TreeNode x, y, prev;
    public void recoverTree(TreeNode root) {
        if(root==null) return;
		find(root);
		swap(x,y);
    }
		
	public void find(TreeNode root) 
    {
        if(root==null) return;
        find(root.left);
		if(prev!=null && prev.val>root.val) 
        {
            y=root;
            if(x==null) x=prev;
            else return;
        }
        prev=root;
        find(root.right);
    }
    
    void swap(TreeNode one, TreeNode two) 
    {
        int tmp=one.val;
        one.val=two.val;
        two.val=tmp;
    }
}
