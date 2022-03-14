//Tamonash Chakraborty
//O(n^2)
class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean dug[][]=new boolean[n][n];
        for(int x[]:dig)
        dug[x[0]][x[1]]=true;
        
        int ans=0,i,j;
        for(int x[]:artifacts)
        {
            int full=0;
            for(i=x[0];i<=x[2];i++)
            for(j=x[1];j<=x[3];j++)
            if(dug[i][j]) full++;
            if(full==(x[2]-x[0]+1)*(x[3]-x[1]+1)) ans++;
        }
        return ans;
    }
}
