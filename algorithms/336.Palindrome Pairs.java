class Solution {
    public List<List<Integer>> palindromePairs(String[] w) {
        List<List<Integer>> ans=new ArrayList<>();
        int n=w.length,i,j;
        Trie r=new Trie();
        for(i=0;i<n;i++)
        {
            Trie root=r;
            for(j=w[i].length()-1;j>=0;j--) //add words to trie 
            {
                int c=w[i].charAt(j)-'a';
                if(root.next[c]==null) root.next[c]=new Trie();
                if(palindrome(w[i],0,j)) root.list.add(i);
                root=root.next[c];
            }
            root.list.add(i);
            root.index=i;
        }
    
        for(i=0;i<n;i++)
        {
            Trie cur=r;
            for(j=0;j<w[i].length();j++)    //searching for palindromes
            {
                if(cur.index>=0 && cur.index!=i && palindrome(w[i],j,w[i].length()-1))
                {
                    List add=new ArrayList<>();
                    add.add(i); add.add(cur.index);
                    ans.add(add);
                }
                cur=cur.next[w[i].charAt(j)-'a'];
                if(cur==null) break;
            }
            
            if(cur!=null)
            for(int x:cur.list)
            if(x!=i)
            {   
                List add=new ArrayList<>();
                add.add(i); add.add(x);
                ans.add(add);
            }
        }
        return ans;
    }
    
    
    boolean palindrome(String s,int l,int r)
    {
        while(l<r)
        if(s.charAt(l++)!=s.charAt(r--)) return false;
        return true;
    }
    
    class Trie
    {
        Trie[] next;
        int index;
        List<Integer> list;
    	
        Trie() 
        {
    	    next=new Trie[26];
    	    index=-1;
    	    list=new ArrayList<>();
        }
    }
}
