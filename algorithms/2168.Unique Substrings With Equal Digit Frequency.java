//Tamonash Chakraborty
//using polynomial hash to find unique substrings
//O((n^2)*10)
class Solution {
    public int equalDigitFrequency(String s) {
        int n=s.length(),i;
        long inv[]=new long[n+1],h[]=new long[n+1],pow=1,p=101,M=(int)1e9+7;
        //string hashing
        for(i=0;i<n;i++,pow=pow*p%M)
        h[i+1]=(h[i]+pow*(s.charAt(i)-'0'+1)%M)%M;
        
        inv[n]=power(pow,M-2,M);
        for(i=n-1;i>=0;i--) //calculate inverses(to prevent calculating them at each step)
        inv[i]=inv[i+1]*p%M;
 
        
        int j,c[]=new int[10];
        Set<Integer> set=new HashSet<>();
        for(i=1;i<=n;i++)
        {
            Arrays.fill(c,0);
            for(j=i;j<=n;j++)   //check subarray
            {
                c[s.charAt(j-1)-'0']++;
                if(ok(c))
                {
                    long hash=(h[j]-h[i-1]+M)%M;
                    hash=hash*inv[i-1]%M;
                    set.add((int)hash); //we need unique values only
                }
            }
        }
        return set.size();
    }
    
    boolean ok(int c[])
    {
        int u=0;
        for(int x:c)
        if(x!=0)    //this digit is present in substring
        {
            if(u==0) u=x;   //previous all counts are zero
            else if(x!=u) return false; //mismatch in frequency
        }
        return true;
    }
    
    long power(long a,long b,long M)
    {
        long res=1;
        while(b!=0)
        {
            if(b%2==1) res=res*a%M;
            b>>=1;
            a=a*a%M;
        }
        return res;
    }
}
