/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    Node pre=null;  //last visited node
    public Node flatten(Node head) {
        if(head==null) return head;
        
        if(pre!=null) 
        {
            pre.next=head;  //connect last visited node with current node
            head.prev=pre;
        }
        pre=head;
        Node next=head.next;    //Store head.next in a next pointer in case recursive call to flatten head.child overrides head.next
        flatten(head.child);
        head.child=null;
        flatten(next);
        return head;
    }
}
