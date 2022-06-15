class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        
        int i,n=spells.length,ans[]=new int[n];
        for(i=0;i<n;i++)
        {
            long mul=success/spells[i];
            if(success%spells[i]!=0) mul++;
            ans[i]=potions.length-smallest(potions,mul);
        }
        return ans;
    }
    
    int smallest(int a[],long k)
    {
        int l=0,r=a.length-1,ans=r+1,mid;
        while(l<=r)
        {
            mid=(l+r)>>1;
            if(a[mid]>=k)
            {
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
}
