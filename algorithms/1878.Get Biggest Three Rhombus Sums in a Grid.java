class Solution {
    public int[] getBiggestThree(int[][] g) {
        int n=g.length,m=g[0].length,i;
        TreeSet<Integer> set=new TreeSet<>(Collections.reverseOrder());
        for(i=Math.min((n+1)/2,(m+1)/2);i>0;i--)
        {
            Set<Integer> te=sums(g,i);
            for(int x:te) set.add(x);
        }
        int ans[]=new int[Math.min(set.size(),3)];
        i=0;
        for(int x:set)
        if(i<ans.length) ans[i++]=x;    
        return ans;
    }
    
    Set<Integer> sums(int g[][],int k)
    {
        int i,j,n=g.length,m=g[0].length;
        Set<Integer> ans=new HashSet<>();
        for(i=0;i<n;i++)
        for(j=0;j<m;j++)
        {
            int p[][]={{i-k+1,j+k-1},{i,j+2*k-2},{i+k-1,j+k-1},{i,j}};
            boolean pos=true;
            for(int pt[]:p)
            if(pt[0]<0 || pt[0]>=n || pt[1]<0 || pt[1]>=m) {pos=false; break;}
            if(!pos) continue;
            
            int x=i,y=j,sum=0;
            while(x>=p[0][0] && y<=p[0][1])
            {
                sum+=g[x][y];
                x--; y++;
            }
            x++; y--; sum-=g[x][y];
            while(x<=p[1][0] && y<=p[1][1])
            {
                sum+=g[x][y];
                x++; y++;
            }
            x--; y--; sum-=g[x][y];
            while(x<=p[2][0] && y>=p[2][1])
            {
                sum+=g[x][y];
                x++; y--;
            }
            x--; y++; sum-=g[x][y];
            while(x>=p[3][0] && y>=p[3][1])
            {
                sum+=g[x][y];
                x--; y--;
            }
            x++; y++; if(k!=1) sum-=g[x][y];
            ans.add(sum);
        }
        return ans;
    }
}
