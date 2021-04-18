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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null && n==1) return head.next;
        ListNode cur=head.next,ptr=head.next,prev=head;
        int i=n-1;
        while(i>0)
        {
            ptr=ptr.next;
            i--;
        }
        while(ptr!=null && ptr.next!=null)
        {
            ptr=ptr.next;
            prev=cur;
            cur=cur.next;
        }
        if(ptr==null) return cur;
        prev.next=cur.next;
        return head;
    }
}
