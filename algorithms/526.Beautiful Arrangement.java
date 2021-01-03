class Solution {
    int ans=0;
    public int countArrangement(int n) {
        boolean used[]=new boolean[n+1];
        calc(n,1,used);
        return ans;
    }
    
    void calc(int n,int i,boolean used[])
    {
        if(i>n) {ans++; return;}
        for(int x=1;x<=n;x++)
        if(!used[x] && (i%x==0 || x%i==0))
        {
            used[x]=true;
            calc(n,i+1,used);
            used[x]=false;
        }
    }
}
