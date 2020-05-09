class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==1) return true;
        int l=2,r=num/2,mid=0;
        while(l<=r)
        {
            mid=l+(r-l)/2;
            long val=1l*mid*mid;
            if(val==num) return true;
            else if(val>num) r=mid-1;
            else l=mid+1;
        }
        return false;
    }
}
