/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb=new StringBuilder();
        preorder(root,sb);
        return sb.toString().trim();
    }
    
    private void preorder(TreeNode root, StringBuilder sb) {
        if(root==null) return;
        sb.append(root.val+" ");
        preorder(root.left,sb);
        preorder(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String[] s=data.split(" ");
        return helper(s,0,s.length-1);
    }
    
    public TreeNode helper(String s[],int start,int end) {
        if(start>end) return null;
        TreeNode root=new TreeNode(Integer.parseInt(s[start]));
        int i;
        for(i=start;i<=end;i++)
        if(Integer.parseInt(s[i])>Integer.parseInt(s[start])) break;
        
        root.left=helper(s,start + 1, i-1);
        root.right=helper(s,i,end);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
