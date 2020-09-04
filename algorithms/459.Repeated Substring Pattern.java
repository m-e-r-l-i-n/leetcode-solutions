class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int i,j,l=s.length();
        if(l<2) return false;
        int c[]=new int[26];
        for(i=0;i<l;i++)
        c[s.charAt(i)-'a']++;
        for(i=0;i<26;i++)
        if(c[i]==l) return true;
        
        for(i=2;i<=l/2;i++)
        {
            if(l%i==0) 
            {
                String cur=s.substring(0,i);
                boolean pos=true;
                for(j=i;j+i<=l;j+=i)
                if(!s.substring(j,j+i).equals(cur)) {pos=false; break;}
                if(pos) return true;    
                if(l/i!=i)
                {
                    cur=s.substring(0,l/i);
                    for(j=l/i;j+l/i<=l;j+=l/i)
                    if(!s.substring(j,j+l/i).equals(cur)) {pos=false; break;}
                    if(pos) return true;
                }
            }
        }
        return false;
    }
}
