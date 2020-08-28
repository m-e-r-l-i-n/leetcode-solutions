class Solution {
    public int numDecodings(String s) {
        if(s==null || s.length()==0) return 0;
        int n=s.length(),i;
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=s.charAt(0)!='0'?1:0;
        for(i=2; i<=n;i++) 
        {
            int first=s.charAt(i-1)-'0';
            int second=(s.charAt(i-2)-'0')*10+first;
            if(first>=1 && first<=9) dp[i]+=dp[i-1];
            if (second>=10 && second<=26)
                dp[i]+=dp[i-2];
        }
        return dp[n];
    }
}
