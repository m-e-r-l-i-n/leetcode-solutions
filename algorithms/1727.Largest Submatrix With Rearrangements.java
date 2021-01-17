class Solution {
    public int largestSubmatrix(int[][] a) {
        int n=a.length,m=a[0].length,i,j,h[][]=new int[n+1][m+1];
        for(i=0;i<m;i++)
        {
            h[0][i]=a[0][i];
            for(j=1;j<n;j++)
            h[j][i]=a[j][i]==0?0:h[j-1][i]+1;    
        }
        
        //vive la gfg
        int c[]=new int[n+1];
        for(i=0;i<n;i++) 
        { 
            ArrayList<Integer> key=new ArrayList<>();
            for(j=0;j<m;j++)
            {
                c[h[i][j]]++;
                if(c[h[i][j]]==1) key.add(h[i][j]);
            }
  
            Collections.sort(key,Collections.reverseOrder());
            int k,col=0; 
            
            for(int y:key) 
            { 
                for(k=0;k<c[y];k++) 
                { 
                    h[i][col]=y; 
                    col++; 
                } 
                c[y]=0;
            } 
        } 
        
        int ans=0;
        for(i=0;i<n;i++)
        for(j=0;j<m;j++)
        ans=Math.max(ans,(j+1)*h[i][j]);
        return ans;
    }
}
