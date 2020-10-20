/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node==null) return null;
        return dfs(node,new HashMap<>());
    }
    
    Node dfs(Node n, HashMap<Node, Node> map) 
    {
        if (map.containsKey(n)) return map.get(n);
        Node clone=new Node(n.val);
        map.put(n,clone); // map OLD node to NEW node!
        for(Node no : n.neighbors)
            clone.neighbors.add(dfs(no,map));
        return clone;
    }
}
