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
    public ListNode oddEvenList(ListNode head) 
    {
        if(head==null || head.next==null) return head;
        int i=1;
        ListNode odd=new ListNode();
        ListNode even=new ListNode();
        ListNode oc=odd;
        ListNode ec=even;
        ListNode cur=head;
        while(cur!=null)
        {
            if(i%2==1)
            {
                oc.next=cur;
                oc=oc.next;
            }
            else
            {
                ec.next=cur;
                ec=ec.next;
            }
            i++;
            cur=cur.next;
        }
        oc.next=even.next;
        ec.next=null;
        return odd.next;
    }
}
