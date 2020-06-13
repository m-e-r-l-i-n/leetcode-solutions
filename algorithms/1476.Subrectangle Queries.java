class SubrectangleQueries {
    int m[][];
    public SubrectangleQueries(int[][] rc) {
        m=new int[rc.length][rc[0].length];
        int i,j;
        for(i=0;i<m.length;i++)
        for(j=0;j<m[0].length;j++)
        m[i][j]=rc[i][j];    
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        int i,j;
        for(i=row1;i<=row2;i++)
        for(j=col1;j<=col2;j++)
        m[i][j]=newValue;    
    }
    
    public int getValue(int row, int col) {
        return m[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */
