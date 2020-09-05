class Solution {
    public int findLengthOfShortestSubarray(int[] a) {
        int i,n=a.length;
        ArrayList<Integer> l=new ArrayList<>();
        ArrayList<Integer> r=new ArrayList<>();
        l.add(a[0]);
        for(i=1;i<n;i++)
        if(a[i]>=a[i-1]) l.add(a[i]);
        else break;
        if(i==n) return 0;
        
        r.add(a[n-1]);
        for(i=n-2;i>=0;i--)
        if(a[i]<=a[i+1]) r.add(a[i]);
        else break;
        
        int min=Math.min(n-l.size(),n-r.size());
        Collections.reverse(r);
        for(i=l.size()-1;i>=0;i--)
        {
            int cur=i+1+count(r,l.get(i));
            min=Math.min(min,n-cur);
        }
        return min;
    }
    
    int count(ArrayList<Integer> al,int k)
    {
        if(k<=al.get(0)) return al.size();
        int l=0,r=al.size()-1,mid,ans=al.size();
        while(l<=r)
        {
            mid=(l+r)/2;
            if(al.get(mid)>=k) r=mid-1;
            else 
            l=ans=mid+1;
        }
        return al.size()-ans;
    }
}
