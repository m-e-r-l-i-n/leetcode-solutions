class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int n=nums.length;
        if(n==1) return Math.min(Math.abs(nums[0]-goal),Math.abs(goal));
        ArrayList<Integer> t=new ArrayList<>();
        int i;
        for(i=0;i<n/2;i++)
        t.add(nums[i]);
        ArrayList<Integer> a=getsum(t);
        t=new ArrayList<>();
        for(i=n/2;i<n;i++)
        t.add(nums[i]);
        ArrayList<Integer> b=getsum(t);
        Collections.sort(b);
        
        int ans=Integer.MAX_VALUE;
        for(i=0;i<a.size();i++)
        {
            int p=maxpos(b,goal,a.get(i));
            ans=Math.min(ans,Math.abs(goal-b.get(p)-a.get(i)));
            if(p+1<b.size()) ans=Math.min(ans,Math.abs(goal-b.get(p+1)-a.get(i)));
        }
        return ans;
    }
    
    ArrayList<Integer> getsum(ArrayList<Integer> a)
    {
        int n=a.size(),i,m=1<<n,j;
        Set<Integer> t=new HashSet<>();
        for(i=0;i<m;i++)
        {
            int s=0;
            for(j=0;j<n;j++)
            if(((i>>j)&1)==1) s+=a.get(j);
            t.add(s);
        }
        return new ArrayList<>(t);
    }
    
    int maxpos(ArrayList<Integer> a,int k,int c)
    {
        int l=0,r=a.size()-1,m,ans=0;
        while(l<=r)
        {
            m=(l+r)>>1;
            if(a.get(m)+c>k) r=m-1;
            else
            {
                ans=m;
                l=m+1;
            }
        }
        return ans;
    }
}
