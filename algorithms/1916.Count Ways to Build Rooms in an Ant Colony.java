class Solution {
    public int waysToBuildRooms(int[] pr) {
        int i,N=100000;
        f=new long[N+1];
        f[0]=1;
        for(i=1;i<=N;i++) f[i]=f[i-1]*i%M;
        
        int n=pr.length,d[]=new int[n];
        ArrayList<Integer> g[]=new ArrayList[n];
        for(i=0;i<n;i++) g[i]=new ArrayList<>(); 
        for(i=1;i<n;i++) g[pr[i]].add(i);
        return (int)count(g,d,0);
    }
    
    long f[],M=1000000007;
    
    long count(ArrayList<Integer> g[],int d[],int n)
    {
        d[n]++;
        long ans=1;
        for(int x:g[n])
        {
            ans=ans*count(g,d,x)%M;
            d[n]+=d[x];
        }
        
        int x=d[n]-1;
        for(int i=1;i<g[n].size();i++)
        {
            ans=ans*ncr(x,d[g[n].get(i)])%M;
            x-=d[g[n].get(i)];
        }    
        return ans;
    }
    
    long ncr(int n,int r)
    {
        return f[n]*power(f[n-r],M-2)%M*power(f[r],M-2)%M;
    }
    
    long power(long a,long b)
    {
        long res=1;
        while(b!=0)
        {
            if(b%2==1) res=res*a%M;
            b>>=1;
            a=a*a%M;
        }
        return res;
    }
}
