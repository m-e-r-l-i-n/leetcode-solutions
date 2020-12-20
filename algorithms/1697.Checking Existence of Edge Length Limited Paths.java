class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] e, int[][] qry) 
    {
        int m=e.length,q=qry.length,i;
        Query qr[]=new Query[q];
        for(i=0;i<q;i++)
        qr[i]=new Query(qry[i][0],qry[i][1],qry[i][2],i);

        Arrays.sort(e, new Comparator<int[]>() {
            public int compare(int o1[],int o2[]) 
            {
                if(o1[2]>o2[2]) return 1;
                else if(o1[2]==o2[2]) return o1[0]>=o2[0]?1:-1;
                else return -1;
            }});
        Arrays.sort(qr, new Comparator<Query>() {
            public int compare(Query o1, Query o2) {
                if(o1.wt>o2.wt) return 1;
                else if(o1.wt==o2.wt) return o1.id>o2.id?1:-1;
                else return -1;
            }});
        
        boolean ans[]=new boolean[q];
        int j=0;
        DSU ds=new DSU(n);
        for(i=0;i<q;i++)
        {
            while(j<m && e[j][2]<qr[i].wt)
            {
                ds.unite(e[j][0],e[j][1]);
                j++;
            }
            ans[qr[i].id]=(ds.getPar(qr[i].x)==ds.getPar(qr[i].y));
        }
        return ans;
    }
    
    class DSU
    {
        int connected,par[],sz[];

        DSU(int n)
        {
            par=new int[n];
            sz=new int[n];
            for(int i=0;i<n;i++)
            {
                par[i]=i;
                sz[i]=1;
            }
            connected=n;
        }

        int getPar(int u)
        {
            while(u!=par[u])
            {
                par[u]=par[par[u]];
                u=par[u];
            }
            return u;
        }

        void unite(int u, int v)
        {
            int par1=getPar(u),par2=getPar(v);

            if(par1==par2) return;
            connected--;
            if(sz[par1]>sz[par2])
            par1=par1^par2^(par2=par1);

            sz[par2]+=sz[par1];
            sz[par1]=0;
            par[par1]=par[par2];
        }
    }

    class Query
    {
        int x,y,wt,id;
        Query(int a,int b,int c,int d)
        {
            x=a;
            y=b;
            wt=c;
            id=d;
        }
    }

}
