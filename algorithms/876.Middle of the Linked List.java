/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        int l=0;
        ListNode top=head;
        while(top.next!=null) 
        {top=top.next; l++;}
        int i=0;
        top=head;
        while(i<(l+1)/2)
        {top=top.next; i++;}
        return top;
    }
}
