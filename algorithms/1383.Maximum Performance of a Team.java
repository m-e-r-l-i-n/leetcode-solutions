class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int o1[],int o2[])
            {
                if(o1[1]<o2[1]) return 1;
                else if(o1[1]==o2[1]) return o1[0]<o2[0]?1:-1;
                else return -1;
            }});
        
        long ans=0,sum=0;
        int i;
        for(i=0;i<n;i++)
        pq.add(new int[]{speed[i],efficiency[i]});
        PriorityQueue<Integer> sums=new PriorityQueue<>();
        
        for(i=0;i<n;i++)
        {
            int a=pq.peek()[0];
            sums.add(a);
            sum+=a;
            while(sums.size()>k) sum-=sums.poll();
            ans=Math.max(ans,sum*pq.peek()[1]);
            pq.poll();
        }    
        return (int)(ans%1000000007);
    }
}
