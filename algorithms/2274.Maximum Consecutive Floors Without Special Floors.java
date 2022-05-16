//Tamonash Chakraborty
//O(nlogn)
class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int i,n=special.length,ans=0;
        for(i=1;i<n;i++)
        ans=Math.max(ans,special[i]-special[i-1]-1);   //check the gap between this and prev

        ans=Math.max(ans,top-special[n-1]); //check the last value
        ans=Math.max(ans,special[0]-bottom);    //check the first value
        return ans;
    }
}
