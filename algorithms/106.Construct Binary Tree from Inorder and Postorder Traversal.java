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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0) return null;
        Stack<TreeNode> s=new Stack<TreeNode>();
        TreeNode root=new TreeNode(postorder[postorder.length-1]);
        s.push(root);
        int i=postorder.length-2,j=inorder.length-1;
        
        while(i>=0)
        {
            TreeNode cur=s.peek();
            if(cur.val!=inorder[j])
            {
                TreeNode right=new TreeNode(postorder[i]);
                cur.right=right;
                s.push(right);
                i--;
            }
            else
            {
                while(!s.isEmpty() && s.peek().val==inorder[j]) 
                {
                    cur=s.pop();
                    j--;
                }
            
                TreeNode left=new TreeNode(postorder[i]);
                cur.left=left;
                s.push(left);
                i--;
            }
        }
    return root;
    }
}
