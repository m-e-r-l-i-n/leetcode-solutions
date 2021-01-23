class Solution {
    public int[] decode(int[] e) {
        int xor=0,i,n=e.length+1;
        for(i=1;i<=n;i++) xor^=i;
        
        int tx=e[0],cx=e[0];
        for(i=1;i<n-1;i++)
        {
            cx^=e[i];   //finding a^x with all x a^b^b^c=a^c, using this 
            tx^=cx;
        }    
        int ans[]=new int[n];
        ans[0]=xor^tx;
        for(i=1;i<n;i++)
        ans[i]=e[i-1]^ans[i-1];
        return ans;
    }
}
