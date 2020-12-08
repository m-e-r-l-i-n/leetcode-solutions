class Solution {
    public int[][] generateMatrix(int n) {
        int a[][]=new int[n][n],t=0,b=n-1,l=0,r=n-1,i,ptr=1;
        while(ptr<=n*n)
        {
            for(i=l;i<=r;i++)
            a[t][i]=ptr++;
            if(ptr>n*n) break;
            t++;
            for(i=t;i<=b;i++)
            a[i][r]=ptr++;
            if(ptr>n*n) break;
            r--;
            for(i=r;i>=l;i--)
            a[b][i]=ptr++;
            if(ptr>n*n) break;
            b--;
            for(i=b;i>=t;i--)
            a[i][l]=ptr++;
            if(ptr>n*n) break;
            l++;
        }
        return a;
    }
}
