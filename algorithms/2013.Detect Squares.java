class DetectSquares {

    int dp[][],N,dir[][];
    public DetectSquares() {
        N=1001;
        dp=new int[N][N];
        dir=new int[][]{{-1,1},{1,-1},{-1,-1},{1,1}};
    }
    
    public void add(int[] p) {
        dp[p[0]][p[1]]++;
    }
    
    public int count(int[] p) {
        int ans=0,i=1;
        while(i<N)
        {
            boolean has=false;
            for(int d[]:dir)
            {
                int tx=p[0]+d[0]*i,ty=p[1]+d[1]*i;
                if(tx<0 || tx>=N || ty<0 || ty>=N) continue;
                has=true;
                ans+=dp[p[0]][ty]*dp[tx][p[1]]*dp[tx][ty];
            }
            i++;
            if(!has) break;
        }
        return ans;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
