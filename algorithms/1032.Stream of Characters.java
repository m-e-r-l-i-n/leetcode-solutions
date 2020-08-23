class StreamChecker {

    class TrieNode 
    {
        boolean is;
        TrieNode[] c=new TrieNode[26];
    }

    TrieNode root=new TrieNode();
    StringBuilder sb=new StringBuilder();

    public StreamChecker(String[] words) 
    {
        for (String s : words) 
        {
            TrieNode n=root;
            int l=s.length(),i;
            for(i=l-1;i>=0;i--) 
            {
                char c=s.charAt(i);
                if(n.c[c-'a']==null)
                    n.c[c-'a']=new TrieNode();
                n=n.c[c - 'a'];
            }
            n.is=true;
        }
    }

    public boolean query(char letter) 
    {
        sb.append(letter);
        TrieNode n=root;
        for (int i=sb.length()-1;i>=0 && n!=null; i--) 
        {
            char c=sb.charAt(i);
            n=n.c[c-'a'];
            if(n != null && n.is) return true;
        }
        return false;
    }
    
        
    
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
