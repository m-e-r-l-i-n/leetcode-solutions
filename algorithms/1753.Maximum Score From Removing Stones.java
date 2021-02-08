class Solution {
    public int maximumScore(int a, int b, int c) {
        int s[]={a,b,c};
        Arrays.sort(s);
        int i,ans=0;
        for(i=0;i<=s[0];i++)
        {
            int t[]={s[0],s[1],s[2]},cur=0;
            t[0]-=i;
            t[1]-=i;
            cur+=i;
            cur+=Math.min(t[0]+t[1],t[2]);
            ans=Math.max(ans,cur);
        }
        return ans;
    }
}
