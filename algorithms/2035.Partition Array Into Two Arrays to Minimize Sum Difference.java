class Solution {
    public int minimumDifference(int[] nums) {
        int n=nums.length;
        ArrayList<Integer>[] part1=subsetsum(nums,0,n/2,false),part2=subsetsum(nums,n/2,n,true);
        int ans=(int)1e9,i;
        for(i=1;i<=n/2;i++)
        for(int x:part1[i])
        {
            int l=lower(part2[n/2-i],-x);
            if(l!=-1) ans=Math.min(ans,Math.abs(x+part2[n/2-i].get(l)));
            
            int h=higher(part2[n/2-i],-x);
            if(h!=-1) ans=Math.min(ans,Math.abs(x+part2[n/2-i].get(h)));
        }
        return ans;
    }
    
    ArrayList<Integer>[] subsetsum(int a[],int l,int r,boolean sort)
    {
        int i,n=r-l,m=1<<n;
        ArrayList<Integer> sum[]=new ArrayList[n+1];
        for(i=0;i<=n;i++) sum[i]=new ArrayList<>();
        for(i=0;i<m;i++)
        {
            int j,s1=0,s2=0,b=0;
            for(j=0;j<n;j++)
            if(((i>>j)&1)==1) {s1+=a[l+j]; b++;}
            else s2+=a[l+j];
            sum[b].add(s1-s2);
        }
        if(sort)
        for(i=0;i<=n;i++) Collections.sort(sum[i]);    
        return sum;
    }
    
    int lower(ArrayList<Integer> a,int x)
    {
        int l=0,r=a.size()-1,mid,ans=-1;
        while(l<=r)
        {
            mid=(l+r)>>1;
            if(a.get(mid)<=x)
            {
                ans=mid;
                l=mid+1;
            }
            else r=mid-1;
        }
        return ans;
    }
    
    int higher(ArrayList<Integer> a,int x)
    {
        int l=0,r=a.size()-1,mid,ans=-1;
        while(l<=r)
        {
            mid=(l+r)>>1;
            if(a.get(mid)>=x)
            {
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
}
