class Solution {
    public boolean canPlaceFlowers(int[] a, int n) {
        int i,l=a.length,c=0,f=0;
        for(i=0;i<l;i++)
        if(a[i]==1) break;
        if(i==l) f=(i+1)/2;
        else f=i/2;
        
        for(;i<l;i++)
        if(a[i]==0) c++;
        else
        {
            c-=2;
            if(c<0) c=0;
            f+=(c+1)/2;
            c=0;
            if(f>=n) return true;
        }
        
        if(c>1) f+=c/2;
        return f>=n;
    }
}
