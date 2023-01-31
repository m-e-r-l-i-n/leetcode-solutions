class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int o1[],int o2[])
            {
                if(o1[0]<o2[0]) return 1;
                else return -1;
            }});
        
        int i,n=nums1.length;
        for(i=0;i<n;i++) pq.add(new int[]{nums2[i],nums1[i]});
        
        long ans=0,sum=0;
        PriorityQueue<Integer> pq2=new PriorityQueue<>();
        while(!pq.isEmpty())
        {
            int e[]=pq.poll();
            sum+=e[1];
            pq2.add(e[1]);
            while(pq2.size()>k) sum-=pq2.poll();
            if(pq2.size()==k) ans=Math.max(ans,sum*e[0]);
        }
        return ans;
    }
}
