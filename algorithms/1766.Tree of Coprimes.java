class Solution {
    public int[] getCoprimes(int[] a, int[][] e) {
        int n=a.length,i;
        g=new ArrayList[n];
        v=new boolean[n];
        c=new int[n][51]; d=new int[n];
        int ans[]=new int[n];
        for(i=0;i<n;i++) g[i]=new ArrayList<>();
        for(int x[]:e)
        {
            g[x[0]].add(x[1]);
            g[x[1]].add(x[0]);
        }    
        d[0]=1; v[0]=true;
        dfs(a,ans,0);
        return ans;
    }
    ArrayList<Integer> g[];
    boolean v[];
    int c[][],d[];
    
    void dfs(int a[],int ans[],int n)
    {
        int i;
        int min=d[n],minv=-1;
        for(i=1;i<=50;i++)
        if(c[n][i]!=0)
        {
            int g=gcd(i,a[n]);
            if(g==1 && d[n]-d[c[n][i]-1]<min)
            {
                min=d[n]-d[c[n][i]-1];
                minv=c[n][i]-1;
            }
        }
        ans[n]=minv;
        c[n][a[n]]=n+1;
        for(int x:g[n])
        if(!v[x])
        {
            v[x]=true;
            d[x]=d[n]+1;
            for(i=1;i<=50;i++)
            c[x][i]=c[n][i];
            dfs(a,ans,x);
        }
    }
    
    int gcd(int a,int b)
    {
        int t;
        while(b!=0)
        {
            t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
}
