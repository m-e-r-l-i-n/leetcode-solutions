class Solution {
    public int minTimeToType(String word) {
        int i,n=word.length(),ans=0,cur=0;
        for(i=0;i<n;i++)
        {
            int c=word.charAt(i)-'a',min=Math.abs(c-cur);
            if(c>=cur) min=Math.min(min,26-c+cur);
            else min=Math.min(min,26-cur+c);
            cur=c;
            ans+=min+1;
        }
        return ans;
    }
}
