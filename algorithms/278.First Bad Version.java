/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l=1,r=n,mid=0,ans=0;
        while(l<=r)
        {
            mid=l+(r-l)/2;
            if(isBadVersion(mid)) {ans=mid; r=mid-1;}
            else l=mid+1;
        }
        return ans;
    }
}
