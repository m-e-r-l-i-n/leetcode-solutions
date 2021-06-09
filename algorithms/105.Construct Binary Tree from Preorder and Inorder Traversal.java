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
    public TreeNode buildTree(int[] pre, int[] in) {
        if(pre.length==0) return null;
        Stack<TreeNode> s=new Stack<>();
        TreeNode root=new TreeNode(pre[0]), cur=root;
        for(int i=1,j=0; i<pre.length; i++) 
        if(cur.val!=in[j]) 
        {
            cur.left=new TreeNode(pre[i]);
            s.push(cur);
            cur=cur.left;
        }
        else
        {
            j++;
            while(!s.isEmpty() && s.peek().val==in[j]) {j++; cur=s.pop();}
            cur.right=new TreeNode(pre[i]);
            cur=cur.right;
        }
        return root;
    }
}
