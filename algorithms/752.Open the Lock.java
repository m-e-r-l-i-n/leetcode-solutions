class Solution {
    public int openLock(String[] dead, String target) {
        boolean d[]=new boolean[10000],v[]=new boolean[10000];
        int i,t=Integer.parseInt(target),dp[]=new int[10000],c[]=new int[4];
        for(i=0;i<dead.length;i++)
        d[Integer.parseInt(dead[i])]=true;
        if(d[0]) return -1;
        Queue<Integer> q=new LinkedList<>();
        q.add(0); v[0]=true;
        while(!q.isEmpty())
        {
            int p=q.poll(),r=p; i=3;
            c[0]=c[1]=c[2]=c[3]=0;
            while(p>0)
            {
                c[i--]=p%10;
                p/=10;
            }
            
            for(i=0;i<4;i++)
            {
                c[i]=(c[i]+1)%10;
                int x=1000*c[0]+100*c[1]+10*c[2]+c[3];
                if(!d[x] && !v[x])
                {
                    dp[x]=dp[r]+1;
                    v[x]=true;
                    q.add(x);
                }
                
                c[i]=(c[i]+8)%10;
                x=1000*c[0]+100*c[1]+10*c[2]+c[3];
                if(!d[x] && !v[x])
                {
                    dp[x]=dp[r]+1;
                    v[x]=true;
                    q.add(x);
                }
                c[i]=(c[i]+11)%10;
            }
            if(v[t]) break;
        }
        if(v[t]) return dp[t];
        return -1;
    }
}
