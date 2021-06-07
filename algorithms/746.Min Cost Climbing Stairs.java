class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length,i,m[]=new int[n+1];
        for(i=2;i<=n;i++)
        m[i]=Math.min(m[i-1]+cost[i-1],m[i-2]+cost[i-2]);
        return m[n];
    }
}
