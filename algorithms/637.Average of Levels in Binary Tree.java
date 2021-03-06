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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<Double> ans=new ArrayList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            double s=0,l=q.size();
            Queue<TreeNode> tq=new LinkedList<>();
            while(!q.isEmpty())
            {
                TreeNode t=q.poll();
                s+=t.val;
                if(t.left!=null) tq.add(t.left);
                if(t.right!=null) tq.add(t.right);
            }
            q=tq;
            ans.add(s/l);
        }
        return ans;
    }
}
