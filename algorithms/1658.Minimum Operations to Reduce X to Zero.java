class Solution {
    public int minOperations(int[] a, int x) {
        int i,n=a.length,s=0;
        for(i=0;i<n;i++)
        s+=a[i];
        if(x>s) return -1;
        if(x==s) return n;
        
        int ans=-1,cur=0; s-=x;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(i=0;i<n;i++)
        {
            cur+=a[i];
            if(cur==s) ans=i+1;
            if(hm.get(cur)==null) hm.put(cur,i);
            if(hm.get(cur-s)!=null) ans=Math.max(ans,i-hm.get(cur-s));
        }
        if(ans!=-1) ans=n-ans;
        return ans;
    }
}
