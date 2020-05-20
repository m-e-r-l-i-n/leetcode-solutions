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
    public int kthSmallest(TreeNode root, int k) {
        int i=0,a[]=new int[k];
        Stack<TreeNode> s=new Stack<>();
        TreeNode n=root;
        while(!s.isEmpty() || n!=null)
        {
            while(n!=null)
            {
                s.push(n);
                n=n.left;
            }
            n=s.pop();
            if(i<k) a[i++]=n.val;
            else break;
            n=n.right;
        }
        return a[i-1];
    }
}
