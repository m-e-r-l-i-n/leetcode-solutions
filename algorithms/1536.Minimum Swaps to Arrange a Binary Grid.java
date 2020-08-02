class Solution {
    public int minSwaps(int[][] grid) {
        int i,n=grid.length,ans=0,cur=0;
        Grid a[]=new Grid[n];
        for(i=0;i<n;i++)
        a[i]=new Grid(grid[i],i,i);
        
        boolean used[]=new boolean[n];
        for(i=n-1;i>0;i--)
        {
            int j,minp=-1;
            for(j=0;j<n;j++)
            if(used[a[j].id]) continue;
            else
            {
                if(a[j].c>=i) {minp=j; break;}
            }
            if(minp==-1) return -1;
            
            used[a[minp].id]=true;
            ans+=a[minp].g-cur;
            cur++;
            int t=cur;
            for(j=0;j<minp;j++)
            if(!used[a[j].id]) a[j].g=t++;    
        }
        return ans;
    }
    
    class Grid
    {
        int a[],g,c,id;
        Grid(int gr[],int x,int y)
        {
            a=gr;
            g=x;
            id=y;
            c=0;
            for(int i=a.length-1;i>=0;i--)
            if(a[i]==0) c++;
            else break;
        }
    }
}
