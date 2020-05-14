class Trie {
    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root=new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur=root;
        for(int i=0;i<word.length();i++)
        {
            char ch=word.charAt(i);
            if(cur.child[ch-'a']==null) cur.child[ch-'a']=new Node(ch);
            cur=cur.child[ch-'a'];
        }
        cur.leaf=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node n=exist(root,word);
        return n!=null && n.leaf; 
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node n=exist(root,prefix);
        return n!=null;
    }
    
    Node exist(Node n,String s)
    {
        for(int i=0;i<s.length();i++)
            if(n.child[s.charAt(i)-'a']==null) return null;
            else n=n.child[s.charAt(i)-'a'];
        return n;
    }
    
    class Node
    {
        char val;
        boolean leaf;
        Node child[];
        
        public Node(char c)
        {
            val=c;
            leaf=false;
            child=new Node[26];
        }
        public Node()
        {
            leaf=false;
            child=new Node[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
