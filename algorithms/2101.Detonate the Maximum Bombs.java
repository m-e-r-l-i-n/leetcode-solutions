//Tamonash Chakraborty
//O(VE)
class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n=bombs.length,i,j;
        ArrayList<Integer> g[]=new ArrayList[n];
        for(i=0;i<n;i++)
        {
            g[i]=new ArrayList<>();
            long r=1l*bombs[i][2]*bombs[i][2];
            //r>=sqrt(dx^2+dy^2) => r^2>=dx^2+dy^2
            for(j=0;j<n;j++)
            {
                long d=distance(bombs[i],bombs[j]);  //square distance between them
                if(r>=d) g[i].add(j);
            }
        }
        
        boolean vis[]=new boolean[n];
        int ans=0;
        Queue<Integer> q=new LinkedList<>();
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++) vis[j]=false;
            int c=1;
            q.add(i); vis[i]=true;
            
            //find number of nodes visitable from here
            while(!q.isEmpty())
            {
                int p=q.poll();
                for(int x:g[p])
                if(!vis[x])
                {
                    vis[x]=true;
                    q.add(x);
                    c++;
                }
            }
            ans=Math.max(ans,c);
        }
        return ans;
    }
    
    long distance(int a[],int b[])
    {
        long x=a[0]-b[0],y=a[1]-b[1];
        return x*x+y*y;
    }
}
