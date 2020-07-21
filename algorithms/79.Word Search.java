class Solution {
    public boolean exist(char[][] board, String word) {
        int i,j; char w[]=word.toCharArray();
        for(i=0;i<board.length;i++)
        for(j=0;j<board[0].length;j++)
        if(board[i][j]==w[0])
        if(dfs(board,w,0,i,j)) return true;
        
        return false;
    }
    
    boolean dfs(char b[][],char w[],int i,int r,int c)
    {
        if(i==w.length) return true;
        if(r<0 || r==b.length || c<0 || c==b[0].length) return false;
        if(b[r][c]!=w[i]) return false;
        
        b[r][c]^=256;   //to mark visited
        i++;
        boolean check=dfs(b,w,i,r+1,c)||dfs(b,w,i,r,c+1)||dfs(b,w,i,r-1,c)||dfs(b,w,i,r,c-1);
        b[r][c]^=256;
        return check;
    }
}
