/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0,sum=0;
        ListNode ln=new ListNode(-1);
        ListNode pointer=ln;
        
        while(l1!=null || l2!=null)
        {
            sum=carry;
            if(l1!=null) {sum+=l1.val;l1=l1.next;}
            if(l2!=null) {sum+=l2.val;l2=l2.next;}
            if(sum>=10)
            {pointer.next=new ListNode(sum-10);
            carry=1;}
            else
            {pointer.next=new ListNode(sum);
            carry=0;}
            pointer=pointer.next;
        }
        
        if(carry==1) 
        pointer.next=new ListNode(1);
        return ln.next;
    }
}
