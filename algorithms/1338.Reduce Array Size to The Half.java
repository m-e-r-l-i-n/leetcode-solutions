class Solution {
    public int minSetSize(int[] arr) {
        int n=arr.length,c[]=new int[n+1],N=100000,m[]=new int[N+1];
        for(int x:arr)
        {
            m[x]++;
            c[m[x]]++;
            c[m[x]-1]--; 
        }
        
        int i=n,ans=0,u=0;
        while(i>0 && u<n/2)
        {
            while(c[i]>0 && u<n/2)
            {
                u+=i;
                ans++;
                c[i]--;
            }
            i--;
        }
        return ans;
    }
}
