class Solution {
    public int[][] rotateGrid(int[][] g, int k) {
        int n=g.length,m=g[0].length,ans[][]=new int[n][m];
        int l=0,r=m-1,u=0,d=n-1,i;
        while(l<=r && u<=d)
        {
            ArrayList<int[]> a=new ArrayList<>();
            for(i=l;i<=r;i++) a.add(new int[]{u,i});
            u++;
            if(d>=u)
            for(i=u;i<=d;i++) a.add(new int[]{i,r});
            r--;
            if(r>=l)
            for(i=r;i>=l;i--) a.add(new int[]{d,i});
            d--;
            if(d>=u)
            for(i=d;i>=u;i--) a.add(new int[]{i,l});
            l++;
            
            int sz=a.size();
            for(i=0;i<sz;i++)
            {
                int nxt=(k+i)%sz;
                ans[a.get(i)[0]][a.get(i)[1]]=g[a.get(nxt)[0]][a.get(nxt)[1]];
            }
        }
        return ans;
    }
}
