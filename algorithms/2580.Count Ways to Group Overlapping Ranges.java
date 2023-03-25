class Solution {
    public int countWays(int[][] ranges) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int o1[],int o2[])
            {
                if(o1[0]>o2[0]) return 1;
                else return -1;
            }});
        for(int x[]:ranges) pq.add(x);
        
        int l=pq.peek()[0],r=pq.poll()[1],ans=0;
        while(!pq.isEmpty())
        {
            int e[]=pq.poll();
            if(e[0]>r)
            {
                ans++;
                l=e[0]; r=e[1];
            }
            else r=Math.max(r,e[1]);
        }
        ans++;
        
        long ret=1,M=(int)1e9+7;
        while(ans-->0) ret=ret*2%M;
        return (int)ret;
    }
}
