class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int ans=0,c[]=new int[60];
        for(int x:time)
        {
            int u=x%60;
            ans+=c[(60-u)%60];
            c[u]++;
        }
        return ans;
    }
}
