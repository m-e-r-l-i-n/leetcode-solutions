//Tamonash Chakraborty
//O(n) for encrypt
//O(len(total words in dictionary)) for decrypt
class Encrypter {
    Trie t;
    HashMap<String,ArrayList<Integer>> map;
    String rmap[];
    
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        List<List<String>> mappings = new ArrayList<List<String>>();
        for (int i = 0; i < keys.length; i++) {
        	List<String> l = new  ArrayList<String>();
            String s = Character.toString(keys[i]);
            l.add(s); l.add(values[i]);
            mappings.add(l);
        }
        
        map=new HashMap<>();    //for decrypt
        rmap=new String[26];    //for encrypt
        for(List<String> pairs:mappings)   
        {
            String key=pairs.get(1);
            if(map.get(key)==null) map.put(key,new ArrayList<>());
            int c=pairs.get(0).charAt(0)-'a';
            map.get(key).add(c);
            
            rmap[c]=key;
        }
        
        t=new Trie();
        for(String x:dictionary) insert(x);
    }
    
    public String encrypt(String word1) {
        StringBuilder res=new StringBuilder();
        for(int i=0;i<word1.length();i++)
        res.append(rmap[word1.charAt(i)-'a']);
        return res.toString();
    }
    
    public int decrypt(String word2) {
        if (word2.length() % 2 != 0)	return 0;
        return count(t,word2,0);
    }
    
    void insert(String s)
    {
        Trie cur=t;
        int i,n=s.length();
        for(i=0;i<n;i++)
        {
            int c=s.charAt(i)-'a';
            if(cur.chi[c]==null) cur.chi[c]=new Trie();
            cur=cur.chi[c];
        }
        cur.v++;    //add end of word
    }
    
    //consider 2 characters have to be mapped to 1 key character
    int count(Trie cur,String s,int i)
    {
        int l=s.length();
        if(i>=l) return cur.v;
        
        String search =""+s.charAt(i)+s.charAt(i+1);
        if(map.get(search)==null) return 0; //corner case
        
        int ans=0;
        for(int x : map.get(search))  //store the mappings as integers, for simplicity
        if(cur.chi[x]!=null) ans+=count(cur.chi[x],s,i+2);
        return ans;
    }
    
    class Trie
    {
        int v;
        Trie chi[];
        Trie()
        {
            v=0;
            chi=new Trie[26];
        }
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(mappings, dictionary);
 * String param_1 = obj.encrypt(word1);
 * List<String> param_2 = obj.decrypt(word2);
 */
