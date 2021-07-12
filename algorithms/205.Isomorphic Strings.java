class Solution {
    public boolean isIsomorphic(String s, String t) {
        int c[]=new int[256],d[]=new int[256],i;
        for(i=0;i<256;i++) c[i]=d[i]=-1;
        
        for(i=0;i<s.length();i++)
        {
            int c1=s.charAt(i),c2=t.charAt(i);
            if(c[c1]==-1 && d[c2]==-1) {c[c1]=c2; d[c2]=c1;}
            if(c[c1]!=c2 || d[c2]!=c1) return false;
        }
        return true;
    }
}
