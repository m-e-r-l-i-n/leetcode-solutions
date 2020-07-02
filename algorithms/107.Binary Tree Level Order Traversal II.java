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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();       
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        Queue<Integer> l=new LinkedList<>();
        q.add(root);
        l.add(1);
        while(!q.isEmpty())
        {
            TreeNode cur=q.poll(); int lev=l.poll();
            if(lev>ans.size()) ans.add(0,new ArrayList<>());
            ans.get(ans.size()-lev).add(cur.val);
            if(cur.left!=null) {q.add(cur.left); l.add(lev+1);}
            if(cur.right!=null) {q.add(cur.right); l.add(lev+1);}
        }
        return ans;
    }
}
