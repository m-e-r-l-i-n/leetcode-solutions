class Solution {
    public int maximumUnits(int[][] b, int t) 
    {
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int o1[],int o2[])
            {
                if(o1[1]<o2[1]) return 1;
                else return -1;
            }});
        
        int i,x,ans=0;
        for(i=0;i<b.length;i++)
        pq.add(b[i]);
        while(!pq.isEmpty())
        {
            int a[]=pq.poll();
            x=Math.min(a[0],t);
            ans+=x*a[1];
            t-=x;
        }
        return ans;
    }
}
