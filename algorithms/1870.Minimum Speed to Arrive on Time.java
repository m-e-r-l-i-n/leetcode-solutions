class Solution {
    public int minSpeedOnTime(int[] a, double hour) {
        int l=1,r=(int)1e9,m,ans=-1; long hr=(long)Math.ceil(hour*100); double last=a[a.length-1];
        while(l<=r)
        {
            m=(l+r)>>1;
            long time=0; int i;
            for(i=0;i<a.length-1;i++)
            {
                time+=a[i]/m;
                if(a[i]%m!=0) time++;
            }
            time*=100;
            time+=(int)Math.ceil(last/m*100);
            //System.out.println(m+" "+time+" "+hr);
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
