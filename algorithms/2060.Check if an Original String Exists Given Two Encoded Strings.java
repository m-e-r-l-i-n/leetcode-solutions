//Tamonash Chakraborty
//O(n^2*sum)
//massive inspiration from astroash
class Solution {
    public boolean possiblyEquals(String s1, String s2) {
        int n=s1.length(),m=s2.length();
        dp=new int[n+1][m+1][2*N+5];
        for(int i=0;i<=n;i++)
        for(int j=0;j<=m;j++) Arrays.fill(dp[i][j],-1);
        
        int ans=possible(s1,s2,0,0,0);
        return ans==1;
    }
    
    int N=1000,dp[][][];
    //a state can be defined as the indices on 2 strings and the current sum
    int possible(String a,String b,int x,int y,int sum) //dp ensures we do not go through same step twice 
    {
        int n=a.length(),m=b.length();
        if(x==n && y==m) return sum==0?1:0;
        if(dp[x][y][sum+N]!=-1) return dp[x][y][sum+N];
        
        int ans=recur(a,b,x,y,sum,true);
        if(ans==1) return dp[x][y][N+sum]=ans;
        
        ans=recur(b,a,y,x,sum,false);
        return dp[x][y][sum+N]=ans;
    }

    int recur(String a,String b,int x,int y,int sum,boolean f) //just simplified(or complicated :-P a bit)
    {
        if(x==a.length()) return 0;
        
        if(a.charAt(x)>='a' && a.charAt(x)<='z')    //do this for letters
        {
            if(sum==0) 
            {
                if(y==b.length() || a.charAt(x)!=b.charAt(y)) return 0;
                if(f) return possible(a,b,x+1,y+1,0);
                else return possible(b,a,y+1,x+1,0);
            }
            
            if(f && sum<0) return possible(a,b,x+1,y,sum+1);
            if(!f && sum>0) return possible(b,a,y,x+1,sum-1); 
            return 0;
        }
        
        int cur=0,i=x,n=a.length(),ans;
        while(i<n && a.charAt(i)>='0' && a.charAt(i)<='9')  //for digits
        {
            cur=cur*10+a.charAt(i++)-'0';
            if(f) ans=possible(a,b,i,y,sum+cur);
            else ans=possible(b,a,y,i,sum-cur);
            if(ans==1) return 1;
        }
        return 0;
    }
}
