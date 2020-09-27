class Solution {
    public int totalHammingDistance(int[] a) {
        int i,j,n=a.length,c[]=new int[32],ans=0;
        for(i=0;i<n;i++)
        {
            j=0;
            while(a[i]!=0)
            {
                c[j++]+=a[i]&1;
                a[i]>>=1;
            }
        }
        for(i=0;i<32;i++)
        ans+=c[i]*(n-c[i]);    
        return ans;
    }
}
