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
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur=head;
        ListNode ans=new ListNode(-1); 
        ans.next=head; 
        ListNode prev=ans;
        while(cur!=null)
        {
            if(cur.val!=val) prev=prev.next;
            else prev.next=cur.next;
            cur=cur.next;
        }
        return ans.next;
    }
}
