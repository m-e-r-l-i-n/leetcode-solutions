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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean z=false;    //for checking zigzag
        while(!q.isEmpty()) 
        {
            List<Integer> l=new ArrayList<>();
            int c=q.size(),i;
            for(i=0;i<c;i++) 
            {
                TreeNode n=q.poll();
                if(z) l.add(0,n.val);
                else l.add(n.val);
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
            }
            res.add(l);
            z=!z;
        }
        return res;
    }
}
