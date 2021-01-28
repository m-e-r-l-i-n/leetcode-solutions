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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ans=new ListNode(0),c=ans;
        while(head!=null)
        {
            boolean rep=false;
            c.next=head;
            head=head.next;
            while(head!=null && c.next.val==head.val)
            {
                rep=true;
                head=head.next;
            }
            if(rep) c.next=null;
            else c=c.next;
        }
        return ans.next;
    }
}
