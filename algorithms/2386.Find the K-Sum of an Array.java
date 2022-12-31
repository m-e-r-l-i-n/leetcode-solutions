class Solution {
    public long kSum(int[] nums, int k) {
        
        int i,n=nums.length;
        long ans=0;
        ArrayList<Integer> a=new ArrayList<>();
        for(i=0;i<n;i++)
        {
            ans+=Math.max(0,nums[i]);
            a.add(Math.abs(nums[i]));
        }
        
        Collections.sort(a);
        PriorityQueue<long[]> pq=new PriorityQueue<>(new Comparator<long[]>(){
            public int compare(long o1[],long o2[])
            {
                if(o1[0]>o2[0]) return 1;
                else if(o1[0]==o2[0]) return o1[1]>o2[1]?1:-1;
                else return -1;    
            }});
        
        long ksmall=0;
        pq.add(new long[]{a.get(0),0});
        //https://stackoverflow.com/questions/33219712/find-k-th-minimum-sum-of-every-possible-subset
        for(i=0;i<k-1;i++)  //since we are considering 0 as an element
        {
            long e[]=pq.poll();
            ksmall=e[0];
            if(e[1]+1<n)
            {
                int j=(int)e[1]+1;
                pq.add(new long[]{e[0]-a.get(j-1)+a.get(j),j});
                pq.add(new long[]{e[0]+a.get(j),j});
            }
        }
        return ans-ksmall;
    }
}
