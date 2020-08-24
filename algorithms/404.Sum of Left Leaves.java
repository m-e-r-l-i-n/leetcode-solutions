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
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        int sum=0;
        if(root!=null) q.add(root);
        while(!q.isEmpty())
        {
            TreeNode n=q.poll();
            if(n.left!=null) q.add(n.left);
            if(n.right!=null) q.add(n.right);
            if(n.left!=null && n.left.left==null && n.left.right==null) sum+=n.left.val;
        }
        return sum;
    }
}
