//Tamonash Chakraborty
//O(26*n)
class Solution {
    public long appealSum(String s) {
        long ans=0;
        for(int i=0;i<26;i++)
        {
            int n=s.length(),last=n,j;
            for(j=n-1;j>=0;j--)
            {
                if(s.charAt(j)-'a'==i) last=j;    
                ans+=n-last;    //from here to all strings>=just next with character i will have this in ans
            }     
        }
        return ans;
    }
}
