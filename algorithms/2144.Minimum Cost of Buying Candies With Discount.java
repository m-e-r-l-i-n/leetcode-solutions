//Tamonash Chakraborty
//O(nlogn)
class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int ans=0,i,n=cost.length;
        for(i=n-1;i>=0;i-=3)
        {
            ans+=cost[i];   //i th
            if(i-1>=0) ans+=cost[i-1];  //(i-1)th if it exists
        }
        return ans;
    }
}
