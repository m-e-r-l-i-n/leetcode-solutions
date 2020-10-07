/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) return head;
        int l=0;
        ListNode tail=head; 
        while(tail.next!=null) 
        { 
            l++;
            tail=tail.next;
        }
        l++;
        tail.next=head; // making list circular
        int r=l-k%l;    //rotate point
        tail=head;
        while(r-->1) 
            tail=tail.next;
        head=tail.next;
        tail.next=null;
        return head;
    }
}
