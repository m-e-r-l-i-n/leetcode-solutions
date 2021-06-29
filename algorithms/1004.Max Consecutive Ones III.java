class Solution {
    public int longestOnes(int[] a, int k) {
        int l=0,i,n=a.length,z=(a[0]+1)%2,ans=0;
        if(a[0]==0 && k>0) ans=1;
        for(i=1;i<n;i++)
        {
            if(a[i]==0) z++;
            while(l<=i && z>k)
            {
                if(a[l]==0) z--;
                l++;
            }
            ans=Math.max(ans,i-l+1);
        }
        return ans;
    }
}
