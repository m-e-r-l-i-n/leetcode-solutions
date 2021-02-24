class Solution {
    public boolean searchMatrix(int[][] a, int t) {
        int n=a.length,m=a[0].length;
        int c=m-1;
        int r=0;
        while(c>= 0 && r<n) 
        {
            if(t==a[r][c]) return true;
            else if(t<a[r][c]) c--;
            else if(t>a[r][c]) r++;
            else return false;
        }
        return false;
    }
}
