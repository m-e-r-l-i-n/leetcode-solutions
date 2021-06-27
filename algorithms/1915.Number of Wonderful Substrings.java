class Solution {
    public long wonderfulSubstrings(String word) {
        int i,j,m=1<<10,x=0;
        long ans=0,c[]=new long[m]; c[0]=1;
        for(i=0;i<word.length();i++)
        {
            x^=1<<(word.charAt(i)-'a');
            ans+=c[x];
            for(j=0;j<10;j++) ans+=c[x^(1<<j)];
            c[x]++;
        } 
        return ans;
    }
}
