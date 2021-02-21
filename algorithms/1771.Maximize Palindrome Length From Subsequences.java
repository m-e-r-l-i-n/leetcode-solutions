class Solution {
    public int longestPalindrome(String w1, String w2) {
        int i,m=w1.length(),n=m+w2.length(),k;
        char s[]=(w1+w2).toCharArray();
        int l[][]=new int[n][n],ans[][]=new int[n][n];
        for(i=0;i<n;i++)
        l[i][i]=1;
        
        for(k=2;k<=n;k++)
        for(i=0;i<n-k+1;i++)
        {
            int j=i+k-1;
            if(s[i]==s[j] && k==2) 
            {
                l[i][j]=2;
                if(j>=m && i<m) ans[i][j]=2;
            }
            else if(s[i]==s[j])
            {
                l[i][j]=l[i+1][j-1]+2;
                if(j>=m && i<m) ans[i][j]=l[i][j];
            }
            else l[i][j]=Math.max(l[i][j-1],l[i+1][j]);
        }
        
        int mx=0;
        for(i=0;i<n;i++)
        for(k=0;k<n;k++) mx=Math.max(mx,ans[i][k]);
        return mx;
    }
}
