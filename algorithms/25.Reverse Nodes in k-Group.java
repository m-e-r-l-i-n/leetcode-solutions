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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ans=new ListNode(0),last=ans,cur=head;
        while(true)
        {
            int rem=k;
            ListNode tem=cur;
            while(tem!=null && rem>0)   //check if there are k nodes to be reversed
            {
                --rem;
                tem=tem.next;
            }
            if(rem>0) {last.next=cur; break;}
            
            ListNode rev=null; rem=k; tem=cur;
            while(rem-->0)  //reverse the k nodes
            {
                ListNode t=tem;
                tem=tem.next;
                t.next=rev;
                rev=t;
            }
            last.next=rev;  //add them
            while(last.next!=null) last=last.next;  //take pointer to end
            cur=tem;
        }
        return ans.next;
    }
}
