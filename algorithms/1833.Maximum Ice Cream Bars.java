class Solution {
    public int maxIceCream(int[] c, int coins) {
        Arrays.sort(c);
        int cur=0,i,n=c.length,ans=0;
        for(i=0;i<n;i++)
        if(cur+c[i]<=coins)
        {
            cur+=c[i];
            ans++;
        }
        return ans;
    }
}
