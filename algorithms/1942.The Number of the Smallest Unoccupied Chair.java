class Solution {
    public int smallestChair(int[][] t, int s) {
        int N=100000,i,n=t.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        Deque<Integer> a[]=new LinkedList[N+1];
        for(i=0;i<2*N;i++) 
        {
            pq.add(i);
            if(i<=N) a[i]=new LinkedList<>();
        }
        for(i=0;i<n;i++)
        a[t[i][0]].addLast(i);
        
        for(i=0;i<=N;i++)
        {
            while(!a[i].isEmpty())
            {
                int v=a[i].poll();
                if(v>=0) 
                {
                    if(v==s) return pq.poll();
                    a[t[v][1]].addFirst(-pq.poll()-1);
                }
                else
                {
                    v=-v-1;
                    pq.add(v);
                }
            }    
        }
        return pq.peek();
    }
}
