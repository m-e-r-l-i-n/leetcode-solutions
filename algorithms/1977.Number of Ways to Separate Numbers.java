class Solution {
    public int numberOfCombinations(String num) {
        int n=num.length(),i,j;
        long top[][]=new long[n][n],M=(int)1e9+7;
        if(num.charAt(0)!='0') top[0][0]=1;
        
        boolean alleq=true;
        for(i=1;i<n;i++) alleq&=num.charAt(i)==num.charAt(0);
        for(i=1;i<n;i++)
        {
            int rem,len;
            for(j=i;j>0;j--)
            if(num.charAt(j)!='0')
            {
                len=i-j; rem=j-1;
                if(rem<len) {top[i][len]=(top[i][len]+top[j-1][rem])%M; continue;}
                if(alleq || bigger(num,j,i,j-1-len,j-1)) top[i][len]=(top[i][len]+top[j-1][len])%M; 
                else if(len-1>=0) top[i][len]=(top[i][len]+top[j-1][len-1])%M;
            }
            
            if(num.charAt(0)!='0') top[i][i]++;
            for(j=1;j<=i;j++)
            top[i][j]=(top[i][j]+top[i][j-1])%M;
        }
        
        return (int)top[n-1][n-1];
    }
    
    boolean bigger(String s,int a,int b,int c,int d)
    {
        int i,n=b-a+1;
        for(i=0;i<n;i++)
        if(s.charAt(a+i)>s.charAt(c+i)) return true;
        else if(s.charAt(a+i)<s.charAt(c+i)) return false;
        return true;
    }
}
