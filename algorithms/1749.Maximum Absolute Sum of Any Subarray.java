class Solution {
    public int maxAbsoluteSum(int[] a) {
        int cur=0,i,n=a.length,ans=0;
        for(i=0;i<n;i++)
        {
            cur=Math.max(a[i],cur+a[i]);
            ans=Math.max(cur,ans);
        }
        ans=Math.abs(ans);
        
        int ans2=Integer.MAX_VALUE; cur=Integer.MAX_VALUE;
        for(i=0;i<n;i++)
        {
            if(cur>0) cur=a[i];
            else cur+=a[i];
            ans2=Math.min(ans2,cur);
        }
        ans2=Math.abs(ans2);
        return Math.max(ans,ans2); 
    }
}
