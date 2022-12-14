class Solution {
    public int maxJump(int[] stones) {
        int n=stones.length;
        if(n<4) return stones[n-1]-stones[0];
        
        int i,ans=0;
        for(i=0;i+2<n;i++) ans=Math.max(ans,stones[i+2]-stones[i]);
        return ans;
    }
}
