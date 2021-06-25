class Solution {
    public int numMatchingSubseq(String s, String[] w) 
    {
        Queue<Integer> c[]=new LinkedList[26];
        int n=w.length,i,ans=0;
        for(i=0;i<26;i++) c[i]=new LinkedList<>();
        for(i=0;i<n;i++) 
        {
            int ch=w[i].charAt(0)-'a';
            c[ch].add(i); c[ch].add(0);
        }
        
        Queue<Integer> t=new LinkedList<>();
        for(i=0;i<s.length();i++)
        {
            int ch=s.charAt(i)-'a';
            while(!c[ch].isEmpty())
            {
                int v=c[ch].poll(),in=c[ch].poll();
                if(in==w[v].length()-1)
                {
                    ans++;
                    continue;
                }
                in++;
                int c2=w[v].charAt(in)-'a';
                if(c2==ch) {t.add(v); t.add(in);}
                else {c[c2].add(v); c[c2].add(in);}
            }
            
            while(!t.isEmpty())
            {
                c[ch].add(t.poll()); c[ch].add(t.poll());
            }
        }
        return ans;
    }
}
