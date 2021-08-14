class Solution {
    public int removeBoxes(int[] boxes) {
        int n=boxes.length;
        dp=new int[n][n][n];
        return removal(boxes,0,n-1,0);
    }
    
    int dp[][][];
    int removal(int a[],int l,int r,int k)
    {
        if(l>r) return 0;
        if(dp[l][r][k]>0) return dp[l][r][k];
        
        int i=l,j=k;
        while(i+1<=r && a[i+1]==a[i]) {i++; j++;}
        int res=(j+1)*(j+1)+removal(a,i+1,r,0);
        
        for(int m=i+1;m<=r;m++)
        if(a[i]==a[m])
        res=Math.max(res,removal(a,i+1,m-1,0)+removal(a,m,r,j+1));
        
        dp[l][r][k]=res;
        return res;
    }
}
