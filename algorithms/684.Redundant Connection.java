class Solution {
    public int[] findRedundantConnection(int[][] e) 
    {
        int n=e.length,p[]=new int[n],i,ans[]={0,0};
        for(i=0;i<n;i++) p[i]=i;
        for(i=0;i<n;i++)
        {
            int x=parent(p,e[i][0]-1),y=parent(p,e[i][1]-1);
            if(x==y) {ans[0]=e[i][0]; ans[1]=e[i][1]; break;}
            p[y]=x;
        }
        return ans;
    }
    
    int parent(int p[],int i)
    {
        if(p[i]==i) return i;
        return p[i]=parent(p,p[i]);
    }
}
