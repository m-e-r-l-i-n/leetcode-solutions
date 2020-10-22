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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> q=new LinkedList<>();
        int ans=1;
        q.add(root);
        while(!q.isEmpty())
        {
            int i,sz=q.size();
            for(i=0;i<sz;i++)
            {
                TreeNode n=q.poll();
                if(n.left==null && n.right==null) return ans;
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
            }    
            ans++;
        }
        return ans;
    }
}
