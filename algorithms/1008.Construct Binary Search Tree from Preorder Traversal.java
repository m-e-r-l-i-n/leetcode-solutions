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
    public TreeNode bstFromPreorder(int[] p) 
    {
        if(p.length==0) return null;
        int i;
        TreeNode head=new TreeNode(p[0]);
        TreeNode prev=head;
        Stack<TreeNode> s=new Stack<>();
        for(i=1;i<p.length;i++)
        {
            TreeNode node=new TreeNode(p[i]);
            if(node.val<prev.val) 
            {
                s.push(prev);
                prev.left=node;
            } 
            else 
            {
                while(!s.isEmpty() && node.val>s.peek().val) prev=s.pop();
                prev.right=node;
            }
            prev=node;
        }
        return head;
    }
}
