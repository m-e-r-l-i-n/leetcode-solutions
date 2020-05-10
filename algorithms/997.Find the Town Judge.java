class Solution {
    public int findJudge(int N, int[][] trust) {
        int i,n=trust.length,trusts[]=new int[1001],trusted[]=new int[1001];
        for(i=0;i<n;i++)
        {
            trusts[trust[i][0]]++;
            trusted[trust[i][1]]++;
        }
        int m=-1;
        for(i=1;i<=1000;i++)
            if(trusts[i]==0 && trusted[i]==N-1) {m=i; break;}
        return m;
    }
}
