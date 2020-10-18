class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n=scores.length,i,j,a[][]=new int[n][2],dp[]=new int[n];
        for(i=0;i<n;i++)
        {
            a[i][1]=scores[i];
            a[i][0]=ages[i];
        }
        Arrays.sort(a,new Comparator<int[]>(){
            public int compare(int o1[],int o2[])
            {
                if(o1[0]>o2[0]) return 1;
                else if(o1[0]==o2[0]) return o1[1]>=o2[1]?1:-1;
                else return -1;
            }});
        
        int ans=a[0][1];
        dp[0]=a[0][1];
        for(i=1;i<n;i++)
        {
            dp[i]=a[i][1];
            for(j=0;j<i;j++)
            if(a[i][0]==a[j][0] || a[i][1]>=a[j][1]) dp[i]=Math.max(dp[i],a[i][1]+dp[j]);
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}
