//Tamonash Chakraborty
//O(n) 1 pass
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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null) return null;    //n=1
        ListNode fast=head,slow=head,prev=null;
        while(fast!=null && fast.next!=null)
        {
            prev=slow;
            slow=slow.next; //moves once
            fast=fast.next.next;    //move 2 times
        }
        
        //slow stores our mid now and prev the index before mid
        prev.next=slow.next;    //deletes mid
        return head;
    }
}
