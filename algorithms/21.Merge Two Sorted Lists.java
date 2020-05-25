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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode head=null,prev=null,cur=null;
        while(l1!=null && l2!=null)
        {
            if(l1.val>l2.val) 
            {
                cur=l2;
                l2=l2.next;
            }
            else 
            {
                cur=l1;
                l1=l1.next;
            }
            if(prev!=null) prev.next=cur;
            else head=cur;
            prev=cur;
        }
        
        if(l1!=null)
        cur.next=l1;
        if(l2!=null)
        cur.next=l2;
        
        return head;
    }
}
