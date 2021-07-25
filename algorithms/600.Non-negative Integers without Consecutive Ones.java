class Solution {
    public int findIntegers(int n) {
        int f[]=new int[31],i,k,ans=0;
        f[0]=1;
        f[1]=2;
        for(i=2;i<31;i++) f[i]=f[i-1]+f[i-2];
        
        k=0; i=30;
        while(i>=0)
        {
            if(((n>>i)&1)==1)
            {
                ans+=f[i];
                if(k==1) return ans;
                k=1;
            }
            else k=0;
            i--;
        }
        return ans+1;
    }
}
