class Solution {
    public String rankTeams(String[] votes) {
        Node n[]=new Node[26];
        int i;
        for(i=0;i<26;i++)
        n[i]=new Node((char)('A'+i));
        for(String s:votes)
        for(i=0;i<s.length();i++)
        n[s.charAt(i)-'A'].c[i]++;
        
        Arrays.sort(n,new Comparator<Node>() {
            public int compare(Node o1, Node o2) 
            {
                for(int i=0;i<26;i++) 
                if(o1.c[i]!=o2.c[i]) return o2.c[i]-o1.c[i];
                return o1.ch-o2.ch;
            }});
        String ans="";
        for(i=0;i<votes[0].length();i++)
        ans+=n[i].ch;
        return ans;
    }
    
    class Node
    {
        char ch;
        int c[]=new int[26];
        Node(char x)
        {
            ch=x;
        }
    }
}
