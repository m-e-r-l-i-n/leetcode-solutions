//Tamonash Chakraborty
//O(n*d)
class Solution {
    public long[] kthPalindrome(int[] queries, int d) {
        int n=queries.length,i;
        
        int x=(d-1)/2; base=1;
        while(x-->0) base*=10;
        
        long palin=base*10-base;
        long ans[]=new long[n];
        for(i=0;i<n;i++) 
        if(queries[i]>palin) ans[i]=-1;
        else ans[i]=getPalindrome(d,queries[i]);
        return ans;
    }
    
    long base;
    long getPalindrome(int n, int k) {
        int x=(n-1)/2;
        long ans=base+ --k;  //start from 0  
        long rev=reverse(ans,2*(x+1)==n);   //reverse of number, note that for odd we dont need last digit
        ans*=base;  //shift answer to add remainder
        if(n%2==0) ans*=10; //we would be needing 1 more space
        ans+=rev;
        return ans;
    }
    
    long reverse(long n,boolean even)
    {
        long rev=0,x=n;
        if(!even) x/=10;    //remove last digit because we need 1 less value
        while(x>0)
        {
            rev=rev*10+x%10;
            x/=10;
        }
        return rev;
    }
}
