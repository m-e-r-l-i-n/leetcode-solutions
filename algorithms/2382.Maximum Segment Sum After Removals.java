class Solution {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int i,n=nums.length;
        long s[]=new long[n],M=(long)1e15;
        for(i=0;i<n;i++)    //cumulative sums
        {
            s[i]=nums[i];
            if(i>0) s[i]+=s[i-1];
        }
        
        TreeMap<Long,Integer> sums=new TreeMap<>();     //store all sums
        TreeMap<Integer,Integer> range=new TreeMap<>(); //store all segments
        sums.put(0l,1); sums.put(s[n-1],1);
        range.put(0,n-1);
        
        long ans[]=new long[n];
        for(i=0;i<n;i++)
        {
            int l=range.lowerKey(removeQueries[i]+1);    //which range this lies in
            int r=range.get(l);
            
            long sum=s[r]-s[l]+nums[l];
            int v=sums.get(sum);    //this value will exist, we need to remove it
            if(v==1) sums.remove(sum);
            else sums.put(sum,v-1);
            range.remove(l);    //remove this range
            
            if(l<removeQueries[i])  //add sum if [l,rangeQueries[i]-1] is an existing range
            {
                sum=s[removeQueries[i]-1]-s[l]+nums[l];
                sums.put(sum,sums.getOrDefault(sum,0)+1);
                range.put(l,removeQueries[i]-1);
            }
            
            if(r>removeQueries[i])  //add sum if [rangeQueries[i]+1,r] is an existing range
            {
                sum=s[r]-s[removeQueries[i]];
                sums.put(sum,sums.getOrDefault(sum,0)+1);
                range.put(removeQueries[i]+1,r);
            }
            
            ans[i]=sums.lowerKey(M);
        }
        return ans;
    }
}
