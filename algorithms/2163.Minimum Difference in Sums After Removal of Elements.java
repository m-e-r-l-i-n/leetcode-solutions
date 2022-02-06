//Tamonash Chakraborty
//O(nlogn)
class Solution {
    public long minimumDifference(int[] nums) {
        int n=nums.length/3,i,l=3*n;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        long ls[]=new long[l],rs[]=new long[l],sum=0;
        
        for(i=0;i<l;i++)
        {
            pq.add(nums[i]);    //minimum sum of n elements, if possible
            sum+=nums[i];
            while(pq.size()>n) sum-=pq.poll();
            if(pq.size()==n) ls[i]=sum;
            else ls[i]=Long.MAX_VALUE;
            if(i>0) ls[i]=Math.min(ls[i],ls[i-1]);  //don't think this will be executed
        }
        
        sum=0;
        pq=new PriorityQueue<>();
        for(i=l-1;i>=0;i--)
        {
            pq.add(nums[i]);    //maximum sum of n elements, if possible
            sum+=nums[i];
            while(pq.size()>n) sum-=pq.poll();
            if(pq.size()==n) rs[i]=sum;
            else rs[i]=Long.MIN_VALUE;
            if(i<l-1) rs[i]=Math.max(rs[i],rs[i+1]);
        }
        
        long ans=Long.MAX_VALUE;
        for(i=0;i+1<l;i++)  //find minimum difference
        if(ls[i]!=Long.MAX_VALUE && rs[i+1]!=Long.MIN_VALUE) ans=Math.min(ans,ls[i]-rs[i+1]);
        return ans;
    }
}
