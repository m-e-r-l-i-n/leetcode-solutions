class Solution {
    public List<List<String>> solveNQueens(int n) {
        ans=new ArrayList<>();
        b=new int[n];
        c=new boolean[4][2*n];
        ch=new char[n];    
        tracbac(0,n);
        return ans;
    }
    
    List<List<String>> ans;
    int b[]; boolean c[][];
    char ch[];
    
    void tracbac(int i,int n)
    {
        int j;
        for(j=0;j<n;j++)
        if(!c[0][i] && !c[1][j] && !c[2][j-i+n] && !c[3][i+j])
        {
            b[i]=j;
            c[0][i]=true;
            c[1][j]=true;
            c[2][j-i+n]=true;
            c[3][i+j]=true;
            
            if(i==n-1)
            {
                List<String> a=new ArrayList<>();
                int u,v;
                for(u=0;u<n;u++)
                {
                    for(v=0;v<n;v++)
                    if(v==b[u]) ch[v]='Q';
                    else ch[v]='.';
                    a.add(new String(ch));
                }    
                ans.add(a);
            }
            else tracbac(i+1,n);
            
            c[0][i]=false;
            c[1][j]=false;
            c[2][j-i+n]=false;
            c[3][i+j]=false;
        }
    }
}
