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
    public ListNode partition(ListNode head, int x) {
        ListNode cur=head,sm=new ListNode(0),sc=sm,la=new ListNode(0),lc=la;
        while(cur!=null)
        {
            if(cur.val<x)
            {
                sc.next=cur;
                sc=cur;
            }
            else
            {
                lc.next=cur;
                lc=cur;
            }
            cur=cur.next;
        }
        lc.next=null;
        sc.next=la.next;
        return sm.next;
    }
}
