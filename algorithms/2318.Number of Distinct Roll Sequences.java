//Tamonash Chakraborty
//O(6^3*n)
class Solution {
    public int distinctSequences(int n) {
        if(n==1) return 6;
        
        long dp[][][]=new long[2][6][6],M=(int)1e9+7;
        int i,j,k,cur=1,g[][]=new int[6][6];
        for(i=0;i<6;i++)
        for(j=0;j<6;j++) 
        {
            g[i][j]=gcd(i+1,j+1);  //store the gcd    
            if(g[i][j]==1 && i!=j) dp[0][i][j]=1;   //this can be a valid pair
        }
        
        for(i=2;i<n;i++)
        {
            for(j=0;j<6;j++)
            for(k=0;k<6;k++) dp[cur][j][k]=0;   //fill with 0
            
            for(j=0;j<6;j++)    //this will be value at i
            for(k=0;k<6;k++)    //this is at i-1
            if(k!=j && g[j][k]==1)    
            for(int l=0;l<6;l++)    //this is at i-2
            if(l!=j) dp[cur][k][j]=(dp[cur][k][j]+dp[cur^1][l][k])%M;
            
            cur^=1;
        }
        
        long ans=0;
        for(i=0;i<6;i++)
        for(j=0;j<6;j++)
        ans=(ans+dp[cur^1][i][j])%M;
        return (int)ans;
    }
    
    int gcd(int a,int b)
    {
        int t;
        while(b!=0)
        {
            t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
}
