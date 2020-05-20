class Solution {
    public int uniquePathsWithObstacles(int[][] ob) {
        int i,j,c[][]=new int[ob.length][ob[0].length];
        for(i=0;i<ob.length;i++)
        if(ob[i][0]==1) break;
        else c[i][0]=1;
        for(i=0;i<ob[0].length;i++)
        if(ob[0][i]==1) break;
        else c[0][i]=1;
        for(i=1;i<ob.length;i++)
        for(j=1;j<ob[0].length;j++)
            if(ob[i][j]==0) c[i][j]=c[i-1][j]+c[i][j-1];
        return c[ob.length-1][ob[0].length-1];
    }
}
