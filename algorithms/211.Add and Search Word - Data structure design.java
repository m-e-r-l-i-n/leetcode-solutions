class WordDictionary {

    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root=new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode n=root;
        for(int i=0;i<word.length();i++)
        {
            if(n.child[word.charAt(i)-'a']==null) n.child[word.charAt(i)-'a']=new TrieNode();
            n=n.child[word.charAt(i)-'a'];
        }    
        n.item=true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return check(word.toCharArray(),0,root);
    }
    
    boolean check(char s[],int l,TrieNode n)
    {
        if(l==s.length) return n.item;
        if(s[l]!='.') return n.child[s[l]-'a']!=null && check(s,l+1,n.child[s[l]-'a']);
        else
        {
            for(int i=0;i<n.child.length;i++)
            if(n.child[i]!=null)
                if(check(s,l+1,n.child[i])) return true;
        }
        return false;
    }
    
    class TrieNode
    {
        TrieNode child[]=new TrieNode[26];
        boolean item=false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
