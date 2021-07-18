class Solution {
    public int[] maxGeneticDifference(int[] p, int[][] queries) {
        int n=p.length,i;
        ArrayList<Integer> g[]=new ArrayList[n],q[]=new ArrayList[n];
        for(i=0;i<n;i++) 
        {
            g[i]=new ArrayList<>();
            q[i]=new ArrayList<>();
        }
        int r=-1;
        for(i=0;i<n;i++)
        if(p[i]==-1) r=i;
        else g[p[i]].add(i);
        
        for(i=0;i<queries.length;i++)
        q[queries[i][0]].add(i);
        
        int ans[]=new int[queries.length];
        root=new Trie();
        dfs(g,ans,q,queries,r);
        return ans;
    }
    
    Trie root;
    void dfs(ArrayList<Integer> g[],int ans[],ArrayList<Integer> q[],int qr[][],int n)
    {
        insert(root,n);
        for(int x:q[n])
        {
            int v=qr[x][1];
            ans[x]=query(root,v);
        }
        
        for(int x:g[n]) dfs(g,ans,q,qr,x);
        delet(root,n);
    }
    
    class Trie
    {
        int v;
        Trie c[];
        Trie()
        {
            v=0;
            c=new Trie[2];
        }
    }
    
    void insert(Trie root,int k)
    {
        Trie temp=root;
        for(int i=21;i>=0;i--)
        {
            // Current bit in the number
            int bit=(k>>i)&1;
            if(temp.c[bit]==null) temp.c[bit]=new Trie();
            temp.c[bit].v++;
            temp=temp.c[bit];
        }
    }
    
    void delet(Trie root,int k)
    {
        Trie temp=root;
        for(int i=21;i>=0;i--)
        {
            int bit=(k>>i)&1;
            temp.c[bit].v--;    //we always delete a node already present
            temp=temp.c[bit];
        }
    }
    
    int query(Trie root,int k)
    {
        int ans=0;
        Trie temp=root;
        for(int i=21;i>=0;i--)
        {
            int bit=(k>>i)&1;
            if(temp.c[1^bit]!=null && temp.c[1^bit].v!=0)
            {
                ans|=1<<i;
                temp=temp.c[1^bit];
            }
            else if(temp.c[bit]!=null && temp.c[bit].v!=0) temp=temp.c[bit];
            else break;
        }
        return ans;
    }
}
