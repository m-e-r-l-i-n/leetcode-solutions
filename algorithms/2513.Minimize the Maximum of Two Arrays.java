//Tamonash Chakraborty
//O(logn)
class Solution {
    public int minimizeSet(int x, int y, int c1, int c2) {
        long lcm=lcm(x,y);

        long l=1,r=(long)1e15,mid,m,ans=r;
        while(l<=r)
        {
            m=(l+r)>>1; mid=m;
            long v1=(m/y)-(m/lcm),v2=(m/x)-(m/lcm);
            m-=(m/y)+(m/x)-(m/lcm);
            long v=Math.min(m,Math.max(c1-v1,0));
            v1+=v;
            m-=v;
            v2+=m;
            if(v1>=c1 && v2>=c2)
            {
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return (int)ans;
    }

    long lcm(long a,long b)
    {
        long p=a*b;
        while(b!=0)
        {
            long t=b;
            b=a%b;
            a=t;
        }
        return p/a;
    }
}
