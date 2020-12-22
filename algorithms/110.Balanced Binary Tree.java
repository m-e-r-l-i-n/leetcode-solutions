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
    
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(isBalanced(root.left) && isBalanced(root.right))
        {
            int left=0,right=0;
            if(root.left!=null) left=root.left.val;
            if(root.right!=null) right=root.right.val;
            root.val=Math.max(left,right)+1;
            return Math.abs(left-right)<=1;
        }
        return false;
    }
}
