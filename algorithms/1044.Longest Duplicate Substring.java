class Solution
{
    String s;
    class TrieNode 
    {
        TrieNode[] next;
        int i;  //start position
        int d;

        TrieNode(int x,int depth) 
        {
            i=x;
            d= depth;
        }
    }
    
    public String longestDupSubstring(String S) 
    {
        s=S;
        int maxStart=0,maxLength=0,i;
        TrieNode root=new TrieNode(0,0);
        for(i=1;i+maxLength<s.length();i++) 
        {
            int l=addNew(root,i);
            if(l>maxLength) 
            {
                maxLength=l;
                maxStart=i;
            }
        }
        return S.substring(maxStart,maxStart+maxLength);
    }

    int getIndex(int i,int depth) 
    {
        return s.charAt(i+depth)-'a';
    }

    int addNew(TrieNode n, int i) 
    {
        int d=n.d;
        if(i+d==s.length()) return d;
        if(n.next==null) 
        {
            n.next=new TrieNode[26];
            n.next[getIndex(n.i,n.d)]=new TrieNode(n.i,d+1);
        }
        int c=getIndex(i,n.d);
        TrieNode x=n.next[c];
        if(x==null) 
        {
            n.next[c]=new TrieNode(i,d+1);
            return d;
        }
        return addNew(x, i);
    }   
}
