/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        ans=new ArrayList<>();
        dfs(root);
        return ans;
    }
    List<Integer> ans;
    
    void dfs(Node n)
    {
        if(n==null) return;
        ans.add(n.val);
        for(Node x:n.children)
        dfs(x);    
    }
}
