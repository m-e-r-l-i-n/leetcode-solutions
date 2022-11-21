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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        ArrayList<Integer> eu=new ArrayList<>();
        inorder(root,eu);
        
        List<List<Integer>> ret=new ArrayList<>();
        for(int x:queries)
        {
            List<Integer> here=new ArrayList<>();
            
            int l=0,r=eu.size()-1,mid,ans=-1;
            while(l<=r)
            {
                mid=(l+r)>>1;
                if(eu.get(mid)<=x)
                {
                    ans=eu.get(mid);
                    l=mid+1;
                }
                else r=mid-1;
            }
            here.add(ans);
            
            l=0; r=eu.size()-1; ans=-1;
            while(l<=r)
            {
                mid=(l+r)>>1;
                if(eu.get(mid)>=x)
                {
                    ans=eu.get(mid);
                    r=mid-1;
                }
                else l=mid+1;
            }
            here.add(ans);
            ret.add(here);
        }
        return ret;
    }
    
    void inorder(TreeNode root,ArrayList<Integer> al)
    {
        if(root.left!=null) inorder(root.left,al);
        al.add(root.val);
        if(root.right!=null) inorder(root.right,al);
    }
}
