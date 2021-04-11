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
    public int deepestLeavesSum(TreeNode root) {
        hm=new HashMap<>();
        sum(root,0);
        int max=-1;
        for(int x:hm.keySet())
        if(x>max) max=x;
        return hm.get(max);
    }
    HashMap<Integer,Integer> hm;
    
    void sum(TreeNode n,int d)
    {
        if(n==null) return;
        if(hm.get(d)==null) hm.put(d,0);
        hm.put(d,hm.get(d)+n.val);
        sum(n.left,d+1);
        sum(n.right,d+1);
    }
}
