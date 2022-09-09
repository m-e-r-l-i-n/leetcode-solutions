class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int l=1,r=chargeTimes.length,mid,ans=0;
        while(l<=r)
        {
            mid=(l+r)/2;
            if(possible(chargeTimes,runningCosts,mid,budget))
            {
                ans=mid;
                l=mid+1;
            }
            else r=mid-1;
        }
        return ans;
    }
    
    boolean possible(int charge[],int cost[],int m,long budget)
    {
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int o1[],int o2[])
            {
                if(o1[0]<o2[0]) return 1;
                else return -1;
            }});
        
        int i,n=charge.length;
        long sum=0;
        for(i=0;i<m;i++) 
        {
            sum+=cost[i];
            pq.add(new int[]{charge[i],i});
        }
        if(sum*m+pq.peek()[0]<=budget) return true;
        
        for(i=m;i<n;i++)
        {
            sum+=cost[i];
            sum-=cost[i-m];
            pq.add(new int[]{charge[i],i});
            while(pq.peek()[1]<=i-m) pq.poll();
            if(sum*m+pq.peek()[0]<=budget) return true;
        }
        return false;
    }
}
