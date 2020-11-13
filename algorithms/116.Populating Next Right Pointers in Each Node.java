/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Queue<Node> q=new LinkedList<>();
        Queue<Node> cur=new LinkedList<>();
        cur.add(root);
        while(!cur.isEmpty())        
        {
            q=cur;
            cur=new LinkedList<>();
            while(!q.isEmpty())
            {
                Node n=q.poll();
                if(q.peek()!=null) n.next=q.peek();
                if(n.left!=null) cur.add(n.left);
                if(n.right!=null) cur.add(n.right);
            }
        }
        return root;
    }
}
