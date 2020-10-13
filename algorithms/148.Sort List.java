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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode m=mid(head);
        ListNode nhead=m.next;
        m.next=null;
        ListNode lans=sortList(head);
        ListNode rans=sortList(nhead);
        return mergeTwoLists(lans,rans);
    }
    
    public ListNode mid(ListNode n) 
    {
        if(n==null || n.next==null) return n;
        ListNode slow=n,fast=n;
         while(fast.next!=null && fast.next.next!=null) 
         {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {
        if(l1==null || l2==null) return l1==null?l2:l1;

        ListNode head=new ListNode(-1); // dummy Node
        ListNode prev=head;

        ListNode c1=l1,c2=l2;
        while(c1!=null && c2!=null) 
        {
            if(c1.val<=c2.val) 
            {
                prev.next=c1;
                prev=c1;
                c1=c1.next;
            } 
            else 
            {
                prev.next=c2;
                prev=c2;
                c2=c2.next;
            }
        }

        if(c2!=null) prev.next=c2;
        else prev.next=c1;
        return head.next;
    }
}
