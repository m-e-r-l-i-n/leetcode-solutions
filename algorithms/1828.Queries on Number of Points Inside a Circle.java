class Solution {
    public int[] countPoints(int[][] p, int[][] q) {
        int n=p.length,qr=q.length,i,j,ans[]=new int[qr];
        for(i=0;i<qr;i++)
        {
            int di=q[i][2]*q[i][2];
            for(j=0;j<n;j++)
            {
                int cr=(q[i][0]-p[j][0])*(q[i][0]-p[j][0])+(q[i][1]-p[j][1])*(q[i][1]-p[j][1]);
                if(cr<=di) ans[i]++;
            }
        }
        return ans;
    }
}
