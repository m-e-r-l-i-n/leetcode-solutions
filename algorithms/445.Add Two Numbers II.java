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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1=new Stack<>(),s2=new Stack<>();
        ListNode cur=l1;
        while(cur!=null)
        {
            s1.add(cur.val);
            cur=cur.next;
        }    
        cur=l2;
        while(cur!=null)
        {
            s2.add(cur.val);
            cur=cur.next;
        }
        
        ans=null;
        int c=0;
        while(!s1.isEmpty() || !s2.isEmpty() || c>0)
        {
            if(!s1.isEmpty()) c+=s1.pop();
            if(!s2.isEmpty()) c+=s2.pop();
            helper(c);
            c/=10;
        }
        return ans;
    }
    ListNode ans;
    
    void helper(int c)
    {
        ListNode t=new ListNode(c%10);
        t.next=ans;
        ans=t;
    }
}
