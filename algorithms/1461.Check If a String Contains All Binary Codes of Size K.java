class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(s.length()<k) return false;
        int m=1<<k,i,c=0,and=(1<<(k-1))-1;
        boolean v[]=new boolean[m];
        for(i=0;i<k;i++)
        c=c*2+s.charAt(i)-'0';
        v[c]=true; m--;
        for(;i<s.length();i++)
        {
            c&=and;
            c=2*c+s.charAt(i)-'0';
            if(!v[c]) m--;
            v[c]=true;
            if(m==0) return true;
        }
        return false;
    }
}
