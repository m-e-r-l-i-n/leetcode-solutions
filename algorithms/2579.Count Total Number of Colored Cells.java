class Solution {
    public long coloredCells(int n) {
        //https://oeis.org/A001844
        return 1l*n*n+1l*(n-1)*(n-1);
    }
}
