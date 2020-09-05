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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> l1=inorder(root1),l2=inorder(root2);
        int i=0,j=0,n=l1.size(),m=l2.size();
        List<Integer> ans=new ArrayList<>();
        
        while(i<n && j<m)
        {
            if(l1.get(i)<l2.get(j)) ans.add(l1.get(i++));
            else ans.add(l2.get(j++));
        }
        
        while(i<n)
            ans.add(l1.get(i++));
        while(j<m)
            ans.add(l2.get(j++));
        return ans;
    }
    
    ArrayList<Integer> inorder(TreeNode n)
    {
        Stack<TreeNode> s=new Stack<>();
        TreeNode cur=n;
        ArrayList<Integer> ans=new ArrayList<>();
        while(cur!=null || !s.isEmpty())
        {
            while(cur!=null)
            {
                s.push(cur);
                cur=cur.left;
            }
            cur=s.pop();
            ans.add(cur.val);
            cur=cur.right;
        }
        return ans;
    }
}
