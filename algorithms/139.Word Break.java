class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int i,j,n=s.length();
        boolean f[]=new boolean[n+1];
        f[0]=true;
        for(i=1;i<=n;i++)
        for(j=0;j<i;j++)
        if(f[j] && wordDict.contains(s.substring(j,i))) 
        {
            f[i]=true;
            break;
        }
        return f[n];
    }
}
