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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode cur=head,ans=new ListNode(),p=ans; int pos=1;
        while(pos!=left) 
        {
            p.next=cur;
            p=p.next;
            cur=cur.next;
            pos++;
        }
        ListNode ptr=null;
        while(pos!=right)
        {
            ListNode t=cur.next;
            cur.next=ptr;
            ptr=cur;
            cur=t;
            pos++;
        }
        
        p.next=cur; p=p.next; cur=cur.next;
        p.next=ptr; 
        while(p.next!=null) p=p.next;
        
        while(cur!=null)
        {
            p.next=cur;
            p=p.next;
            cur=cur.next;
        }
        return ans.next;
    }
}
