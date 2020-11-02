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
    public ListNode insertionSortList(ListNode head) {
        ListNode ans=new ListNode(-1),cur=head;
        while(cur!=null)
        {
            ListNode last=ans,i=ans.next,t=cur.next;
            while(i!=null)
            {
                if(i.val>=cur.val) break;
                last=i;
                i=i.next;
            }
            cur.next=i;
            last.next=cur;
            cur=t;
        }
        return ans.next;
    }
}
