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
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        if(root!=null) count(root,0,hm,sum);
        return c;
    }
    int c=0;
    void count(TreeNode n,int cur, HashMap<Integer,Integer> hm,int sum)
    {
        cur+=n.val;
        if(hm.get(cur-sum)!=null) c+=hm.get(cur-sum);
        hm.put(cur,hm.getOrDefault(cur,0)+1);
        
        if(n.left!=null) count(n.left,cur,hm,sum);
        if(n.right!=null) count(n.right,cur,hm,sum);
        hm.put(cur,hm.get(cur)-1);
    }
    
}
