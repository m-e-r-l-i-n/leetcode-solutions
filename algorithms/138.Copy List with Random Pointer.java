/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        HashMap<Node,Node> hm=new HashMap<>();
        Node n=head;
        while(n!=null) 
        {
            hm.put(n,new Node(n.val));
            n=n.next;
        }
  
        n=head;
        while(n!=null) 
        {
            hm.get(n).next=hm.get(n.next);
            hm.get(n).random=hm.get(n.random);
            n=n.next;
        }
        return hm.get(head);
    }
}
