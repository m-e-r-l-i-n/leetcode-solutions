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
    public ListNode mergeKLists(ListNode[] l) 
    {
        int k=l.length;
        if(k==0) return null;
        
        ListNode ans=new ListNode(0),cur=ans;
        while(!allover(l))
        {
            int min=getmin(l);
            cur.next=l[min];
            l[min]=l[min].next;
            cur=cur.next;
            cur.next=null;
        }
        return ans.next;
    }
    
    boolean allover(ListNode a[])
    {
        for(int i=0;i<a.length;i++)
        if(a[i]!=null) return false;
        return true;
    }
    
    int getmin(ListNode a[])
    {
        int i,min=Integer.MAX_VALUE,mp=-1;
        for(i=0;i<a.length;i++)
        if(a[i]!=null && a[i].val<min)
        {
            min=a[i].val;
            mp=i;
        }
        return mp;
    }
}
