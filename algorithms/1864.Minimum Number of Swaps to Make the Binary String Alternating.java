class Solution {
    public int minSwaps(String s) {
        int ans=Math.min(count(s,'0','1'),count(s,'1','0'));
        if(ans==Integer.MAX_VALUE) ans=-1;
        return ans;
    }
    
    int count(String s,int a,int b)
    {
        int ca=0,cb=0,i,n=s.length();
        for(i=0;i<n;i++)
        if(s.charAt(i)==a) ca++;
        else cb++;
        if((ca-cb)!=0 && (ca-cb)!=1) return Integer.MAX_VALUE;
        int ans=0;
        for(i=0;i<n;i+=2)
        if(s.charAt(i)==a) ans++;
        ans=(n+1)/2-ans;
        return ans;
    }
}
