class Solution {
    public int eatenApples(int[] ap, int[] da) {
        int N=100000,i,ans=0;
        PriorityQueue<Pair> q=new PriorityQueue<>(new Comparator<>(){
            public int compare(Pair o1,Pair o2)
            {
                if(o1.d>o2.d) return 1;
                else if(o1.d==o2.d) return o1.a>o2.a?1:-1;
                else return -1;
            }
        });
        
        for(i=0;i<ap.length;i++)
        {
            while(!q.isEmpty() && (q.peek().d<=i || q.peek().a<=0)) q.poll();
            if(ap[i]!=0) q.add(new Pair(ap[i],i+da[i]));
            if(q.isEmpty()) continue;
            ans++;
            q.peek().a--;
        }
        
        while(!q.isEmpty())
        {
            while(!q.isEmpty() && (q.peek().d<=i || q.peek().a<=0)) q.poll();
            if(q.isEmpty()) break;
            i++; ans++;
            q.peek().a--;
        }
        return ans;
    }
    
    class Pair
    {
        int a,d;
        Pair(int x,int y)
        {
            a=x;
            d=y;
        }
    }
}
