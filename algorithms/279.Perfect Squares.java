class Solution {
    public int numSquares(int n) {
        //4 possible solutions
        if(square(n)) return 1;
        
        while(n%4==0) n/=4; //legrende's three square theorem => n=(4^a)*(8*b+7)
        if(n%8==7) return 4;
        
        for(int i=1;i*i<=n;i++)
        if(square(n-i*i)) return 2;
        return 3;
    }
    
    boolean square(int n)
    {
        int x=(int)Math.sqrt(n);
        return x*x==n;
    }
}
