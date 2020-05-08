class Solution {
    public boolean checkStraightLine(int[][] c) {
        double m=1.0*(c[0][1]-c[1][1])/(c[0][0]-c[1][0]);
        int i; boolean f=true;
        for(i=2;i<c.length;i++)
            if(1.0*(c[i][1]-c[i-1][1])/(c[i][0]-c[i-1][0])!=m) {f=false; break;}
        return f;
    }
}
