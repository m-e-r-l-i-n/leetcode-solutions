class Solution {
    public int titleToNumber(String s) {
        int i,n=s.length(),p[]=new int[n];
        p[0]=1;
        for(i=1;i<n;i++)
        p[i]=p[i-1]*26;
        
        int ans=0,j;
        for(i=n-1,j=0;i>=0;i--,j++)
        ans+=p[j]*(s.charAt(i)-'A'+1);
        return ans;
    }
}
