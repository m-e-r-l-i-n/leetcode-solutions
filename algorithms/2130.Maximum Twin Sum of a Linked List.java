//Tamonash Chakraborty
//O(n)
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
    public int pairSum(ListNode head) {
        if(head==null || head.next==null) return -1;    //no pairs
        
        ListNode slow=head,fast=head,front=head;
        int pairs=0;
        while(fast!=null && fast.next!=null)    //find mid
        {
            slow=slow.next;
            fast=fast.next.next;
            pairs++;
        }
        
        ListNode back=reverse(slow);    //reverse from mid
        
        int ans=-1;
        while(pairs-->0)
        {
            ans=Math.max(ans,front.val+back.val);
            front=front.next;
            back=back.next;
        }
        return ans;
    }
    
    ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        while(head!=null)
        {
            ListNode tem=head.next;
            head.next=prev;
            prev=head;
            head=tem;
        }
        return prev;
    }
}
