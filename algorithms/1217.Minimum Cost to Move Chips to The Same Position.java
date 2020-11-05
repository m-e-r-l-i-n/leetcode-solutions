class Solution {
    public int minCostToMoveChips(int[] p) {
        int i,j,n=p.length,odd=0,even=0;
        for(i=0;i<n;i++)
        if(p[i]%2==0) even++;
        else odd++;
        return Math.min(odd,even);        
    }
}
