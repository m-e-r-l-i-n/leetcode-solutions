class Solution {
    public int countAnagrams(String s) {
        int i,n=s.length();
        long f[]=new long[n+1],in[]=new long[n+1],M=(int)1e9+7;
        f[0]=1;
        for(i=1;i<=n;i++) f[i]=f[i-1]*i%M;
        
        in[n]=power(f[n],M-2,M);
        for(i=n-1;i>=0;i--) in[i]=in[i+1]*(i+1)%M;
        
        long ans=1;
        String st[]=s.split(" ");
        int c[]=new int[26];
        for(String x:st)
        {
            Arrays.fill(c,0);
            for(i=0;i<x.length();i++) c[x.charAt(i)-'a']++;
            
            long here=f[x.length()];
            for(i=0;i<26;i++) here=here*in[c[i]]%M;
            ans=ans*here%M;
        }
        return (int)ans;
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
