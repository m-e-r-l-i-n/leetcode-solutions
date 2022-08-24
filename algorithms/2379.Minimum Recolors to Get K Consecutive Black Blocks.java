class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n=blocks.length(),ans,i,cur=0;
        for(i=0;i<k;i++)
        if(blocks.charAt(i)=='W') cur++;
        ans=cur;
        for(i=k;i<n;i++)
        {
            if(blocks.charAt(i)=='W') cur++;
            if(blocks.charAt(i-k)=='W') cur--;
            ans=Math.min(ans,cur);
        }
        return ans;
    }
}
