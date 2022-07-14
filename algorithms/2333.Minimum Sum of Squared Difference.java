class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int n=nums1.length,k=k1+k2,i;
        for(i=0;i<n;i++) pq.add(Math.abs(nums1[i]-nums2[i]));
        pq.add(0);
        long ans=0;
        i=0;
        while(pq.size()>1 && k>0)
        {
            i++;
            int a=pq.poll(),b=pq.poll();
            long red=1l*(a-b)*i;
            if(red<=k) 
            {
                k-=red; pq.add(b); 
                continue;
            }
            
            int re=k/i;
            a-=re;
            int rem=k%i;
            ans=1l*a*a*(i-rem);
            a--;
            ans+=1l*a*a*rem;
            pq.add(b);
            k=0;
        }
        
        while(!pq.isEmpty()) ans+=1l*pq.peek()*pq.poll();
        return ans;
    }
}
