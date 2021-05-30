class Solution {
    public int[] assignTasks(int[] s, int[] t) 
    {
        int n=s.length,i;
        PriorityQueue<Pair> free=new PriorityQueue<>(new Comparator<>(){
            public int compare(Pair o1,Pair o2)
            {
                if(o1.w>o2.w) return 1;
                else if(o1.w==o2.w) return o1.i>o2.i?1:-1;
                else return -1;
            }});
        PriorityQueue<Pair> used=new PriorityQueue<>(new Comparator<>(){
            public int compare(Pair o1,Pair o2)
            {
                if(o1.t>o2.t) return 1;
                else if(o1.t==o2.t)
                {
                    if(o1.w>o2.w) return 1;
                    else if(o1.w==o2.w) return o1.i>o2.i?1:-1;
                    else return -1;
                }
                else return -1;
            }});
        
        for(i=0;i<n;i++) free.add(new Pair(i,s[i],0));
        
        n=t.length; int ans[]=new int[n]; long cur=0;
        for(i=0;i<n;i++)
        {
            cur=Math.max(cur,i);
            while(!used.isEmpty() && used.peek().t<=cur) free.add(used.poll());
            if(free.isEmpty())
            {
                cur=used.peek().t;
                while(!used.isEmpty() && used.peek().t<=cur) free.add(used.poll());
            }
            ans[i]=free.poll().i;
            used.add(new Pair(ans[i],s[ans[i]],cur+t[i]));
        }    
        return ans;
    }
    
    class Pair
    {
        int i,w; long t;
        Pair(int a,int b,long c)
        {
            i=a;
            w=b;
            t=c;
        }
    }
}
