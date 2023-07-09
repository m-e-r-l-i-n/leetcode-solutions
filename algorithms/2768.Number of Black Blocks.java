class Solution {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        HashMap<Integer,HashSet<Integer>> pts=new HashMap<>(),black=new HashMap<>();
        for(int x[]:coordinates)
        {
            int i,j;
            for(i=x[0]-1;i<=x[0]+1;i++)
            for(j=x[1]-1;j<=x[1]+1;j++)
            insert(pts,i,j);
            
            insert(black,x[0],x[1]);
        }
        
        long ans[]=new long[5];
        ans[0]=1l*(n-1)*(m-1);
        for(int x:pts.keySet())
        for(int y:pts.get(x))
        if(inside(x,y,m,n) && inside(x+1,y,m,n) && inside(x,y+1,m,n) && inside(x+1,y+1,m,n))
        {
            int cnt=0;
            if(blacked(black,x,y)) cnt++;
            if(blacked(black,x+1,y)) cnt++;
            if(blacked(black,x,y+1)) cnt++;
            if(blacked(black,x+1,y+1)) cnt++;
            if(cnt!=0) ans[cnt]++;
        }
        
        for(int i=1;i<5;i++) ans[0]-=ans[i];
        return ans;
    }
    
    void insert(HashMap<Integer,HashSet<Integer>> hm,int x,int y)
    {
        if(hm.get(x)==null) hm.put(x,new HashSet<>());
        hm.get(x).add(y);
    }
    
    boolean inside(int x,int y,int m,int n)
    {
        return x>=0 && x<m && y>=0 && y<n;
    }
    
    boolean blacked(HashMap<Integer,HashSet<Integer>> hm,int x,int y)
    {
        return hm.containsKey(x) && hm.get(x).contains(y);
    }
}
