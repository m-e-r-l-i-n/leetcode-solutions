class Solution {
    public int nthUglyNumber(int n) {
        int a[]=new int[n],i,tw=0,th=0,fi=0;
        a[0]=1;
        int f2=2,f3=3,f5=5;
        for(i=1;i<n;i++)
        {
            int min=Math.min(Math.min(f2,f3),f5);
            a[i]=min;
            if(f2==min) f2=2*a[++tw];
            if(f3==min) f3=3*a[++th];
            if(f5==min) f5=5*a[++fi];
        }
        return a[n-1];
    }
}
