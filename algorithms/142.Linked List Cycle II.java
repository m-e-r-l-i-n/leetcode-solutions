/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode fast=head,slow=head;
        int x=1;
        while((fast!=null && fast.next!=null && fast!=slow) || x!=0)
        {
            slow=slow.next;
            fast=fast.next.next;
            x=0;
        }
        if(fast==null || fast.next==null) return null;
        slow=head;
        while(slow!=fast)
        {
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
