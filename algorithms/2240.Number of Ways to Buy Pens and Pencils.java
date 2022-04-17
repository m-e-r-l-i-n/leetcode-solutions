class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        int i=0;
        long ans=0;
        while(cost1*i<=total)
        {
            ans+=(total-cost1*i)/cost2+1;   //additional 1 for the 0
            i++;
        }
        return ans;
    }
}
