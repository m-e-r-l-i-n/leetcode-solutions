class Solution {
    public int numSubmatrixSumTarget(int[][] A, int target) {
        int res=0,m=A.length,n=A[0].length,i,j;
        for(i=0;i<m;i++)
        for(j=1;j<n;j++) A[i][j]+=A[i][j-1];
        
        Map<Integer, Integer> hm=new HashMap<>();
        for(i=0;i<n;i++)
        for(j=i;j<n;j++) 
        {
            hm.clear();
            hm.put(0,1);
            int cur=0;
            for(int k=0;k<m;k++) 
            {
                cur+=A[k][j]-(i>0?A[k][i-1]:0);
                res+=hm.getOrDefault(cur-target,0);
                hm.put(cur,hm.getOrDefault(cur,0)+1);
            }
        }
        return res;
    }
}
