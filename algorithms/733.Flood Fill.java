class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor) return image;
        dfs(image,sr,sc,image[sr][sc],newColor);
        return image;
    }
    void dfs(int a[][],int r,int c,int col,int newc)
    {
        if(r<0 || r>=a.length || c<0 || c>=a[0].length || a[r][c]!=col) return;
        a[r][c]=newc;
        dfs(a,r+1,c,col,newc);
        dfs(a,r-1,c,col,newc);
        dfs(a,r,c+1,col,newc);
        dfs(a,r,c-1,col,newc);
    }
}
