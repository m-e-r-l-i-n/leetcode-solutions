class Solution {
    public int[] getOrder(int[][] ta) {
        int i,n=ta.length,ans[]=new int[n];
        PriorityQueue<Task> pq=new PriorityQueue<>(new Comparator<Task>(){
            public int compare(Task o1,Task o2)
            {
                if(o1.p>o2.p) return 1;
                else if(o1.p==o2.p) return o1.i>o2.i?1:-1;
                else return -1;
            }});
        
        PriorityQueue<Task> tem=new PriorityQueue<>(new Comparator<Task>(){
            public int compare(Task o1,Task o2)
            {
                if(o1.l>o2.l) return 1;
                else if(o1.l==o2.l) 
                {
                    if(o1.p==o2.p) return o1.i>o2.i?1:-1;
                    else if(o1.p>o2.p) return 1;
                    else return -1;
                }
                else return -1;
            }});
        for(i=0;i<n;i++) tem.add(new Task(i,ta[i][0],ta[i][1]));
        
        long cur=0; i=0;
        while(!tem.isEmpty())
        {
            while(!tem.isEmpty() && tem.peek().l<=cur) pq.add(tem.poll());
            if(pq.isEmpty()) 
            {
                cur=tem.peek().l;
                pq.add(tem.poll());
            }
            cur=Math.max(cur,pq.peek().l)+pq.peek().p;
            ans[i++]=pq.poll().i;
        }
        while(!pq.isEmpty()) ans[i++]=pq.poll().i;
        return ans;
    }
    
    class Task
    {
        int i,l,p;
        Task(int a,int b,int c)
        {
            i=a;
            l=b;
            p=c;
        }
    }
}
