//Tamonash Chakraborty
//O(nm)
class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n=grid.length,m=grid[0].length,i,j,diff[][]=new int[n][m],r[]=new int[n],c[]=new int[m];
        for(i=0;i<n;i++)
        for(j=0;j<m;j++) 
        {
            r[i]+=grid[i][j];
            c[j]+=grid[i][j];
        }
        
        for(i=0;i<n;i++)
        for(j=0;j<m;j++)
        diff[i][j]=r[i]+c[j]-(n-r[i])-(m-c[j]);
        return diff;
    }
}
