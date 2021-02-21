class Solution {
    public int maximumScore(int[] a, int[] m) {
        int n=a.length,i;
        dp=new HashMap[n];
        for(i=0;i<n;i++) dp[i]=new HashMap<>();
        generate(a,m,0,0,n-1);
        return dp[0].get(n-1);
    }
    HashMap<Integer,Integer> dp[];
    
    int generate(int a[],int m[],int i,int x,int y)
    {
        if(y<x || i==m.length) return 0;
        if(dp[x].get(y)==null)
        {
            int v=Math.max(a[x]*m[i]+generate(a,m,i+1,x+1,y),a[y]*m[i]+generate(a,m,i+1,x,y-1));
            dp[x].put(y,v);
        }
        return dp[x].get(y);
    }
}
