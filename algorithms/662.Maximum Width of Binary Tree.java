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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        Queue<Integer> qi=new LinkedList<>();
        q.add(root);
        qi.add(1); //store index, assuming root's index is 1
        int max=0;
        while(!q.isEmpty())
        {
            int size=q.size(),s=0,e=0,i;
            for(i=0;i<size;i++)
            {
                TreeNode node=q.poll();
                int in=qi.poll();
                if(i==0) s=in; //start and end index for each level
                if(i==size-1) e=in;
                if(node.left!=null)
                {
                    q.add(node.left);
                    qi.add(2*in);
                }
                
                if(node.right!=null)
                {
                    q.add(node.right);
                    qi.add(2*in+1);
                }
            }
            max=Math.max(max,e-s+1);
        }
        return max;    
    }
}
