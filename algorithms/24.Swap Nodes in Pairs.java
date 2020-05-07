/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode ans=new ListNode(-1);
        ans.next=head.next;
        
        ListNode pos1=ans.next;
        ListNode pos2=pos1.next;
        pos1.next=head;
        pos1=pos1.next;
        pos1.next=null;
        while(pos2!=null) 
        {
            if (pos2.next==null) 
            {
                pos1.next=pos2;
                break;
            }
            ListNode target=pos2.next.next;
            pos1.next=pos2.next;
            pos1=pos1.next;
            pos1.next=pos2;
            pos1=pos1.next;
            pos1.next=null;
            pos2=target;
        }
        return ans.next;
    }
}
