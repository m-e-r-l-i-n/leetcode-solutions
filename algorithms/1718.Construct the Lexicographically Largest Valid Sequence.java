class Solution {
    public int[] constructDistancedSequence(int n) {
        l=new int[2*n-1];
        v=new boolean[n+1];
        found=false;
        tracbac(0,n);
        return l;
    }
    int l[];
    boolean v[],found;
    void tracbac(int x,int n)
    {
        int i;
        for(i=n;i>=1;i--)
        if(!v[i])
        {
            if(i==1)
            {
                l[x]=1;
                int p=next(x);
                if(p==l.length) {found=true; return;}
                v[i]=true;
                tracbac(p,n);
                if(found) return;
                l[x]=0;
                v[i]=false;
            }
            else if(x+i<l.length && l[x+i]==0)
            {
                l[x]=l[x+i]=i;
                int p=next(x);
                if(p==l.length) {found=true; return;}
                v[i]=true;
                tracbac(p,n);
                if(found) return;
                l[x]=l[x+i]=0;
                v[i]=false;
            }
        }
    }
    
    int next(int i)
    {
        while(i<l.length)
        if(l[i]==0) return i;
        else i++;
        return i;
    }
}
