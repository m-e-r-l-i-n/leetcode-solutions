class Solution {
    public int brokenCalc(int x, int y) {
        int ans=0;
        while(y>x)
        {
            if(y%2==0) {y/=2; ans++;}
            else {y=(y+1)/2; ans+=2;}
        }
        ans+=x-y;
        return ans;
    }
}
