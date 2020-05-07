class Solution {
    public int rangeBitwiseAnd(int m, int n) 
    {
        int res=0,p=msb(m),q=msb(n),v=0;
        while(p==q && p!=-1)
        {
            v=(int)Math.pow(2,p);
            m-=v;
            n-=v;
            res+=v;
            p=msb(m);
            q=msb(n);
        }
        return res;
    }
    
    int msb(int n)
    {
        int i=0,p=-1;
        while(n!=0)
        {
            if((n&1)==1) p=i;
            n>>=1;
            i++;
        }
        return p;
    }
}
