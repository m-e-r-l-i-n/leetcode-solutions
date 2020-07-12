public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int i,res=0;
        for(i=0;i<32;i++)
        {
            res<<=1;    //the bits that are being set are moving left
            res+=n&1;
            n>>=1;  //the remaining bits that need to be checked are moving right
        }
        return res;
    }
}
