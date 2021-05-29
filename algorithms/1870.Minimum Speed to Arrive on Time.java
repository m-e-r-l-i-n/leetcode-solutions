class Solution {
    public int minSpeedOnTime(int[] a, double hr) {
        int l=1,r=(int)1e7,m,ans=-1;
        while(l<=r)
        {
            m=(l+r)>>1;
            double time=0; int i;
            for(i=0;i<a.length-1;i++)
            time+=Math.ceil(1.0*a[i]/m);
            time+=1.0*a[a.length-1]/m;
            if(time<=hr)
            {
                ans=m;
                r=m-1;
            }
            else l=m+1;
        }
        return ans;
    }
}
