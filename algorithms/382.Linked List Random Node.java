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

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    ListNode top;
    Random r;
    public Solution(ListNode head) {
        top=head;
        r=new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode c=top;
        int v=c.val,i;
        for(i=1; c.next!=null;i++)
        {
            c=c.next;
            if(r.nextInt(i+1)==i) v=c.val;                        
        }
        return v;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
