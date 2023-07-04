class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        boolean notprime[]=new boolean[n+1];
        int i,j;
        for(i=2;i<=n;i++)
        if(!notprime[i])
        for(j=2*i;j<=n;j+=i) notprime[j]=true;
        
        List<List<Integer>> ans=new ArrayList<>();
        for(i=2;i<=n-i;i++)
        if(!notprime[i] && !notprime[n-i])    
        {
            List<Integer> pair=new ArrayList<>();
            pair.add(i); pair.add(n-i);
            ans.add(pair);
        }
        return ans;
    }
}
