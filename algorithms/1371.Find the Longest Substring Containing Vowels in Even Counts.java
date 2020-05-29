class Solution {
    public int findTheLongestSubstring(String s) 
    {
        int i,ans=0,cur=0,seen[]=new int[32];  //cur will help us in bitmasking
        Arrays.fill(seen,-2);
        seen[0]=-1;
        for(i=0;i<s.length();i++)
        {
            cur^=1<<("aeiou".indexOf(s.charAt(i))+1)>>1;  
            //1<<("aeiou".indexOf(s[i])+1) toggles count of vowel if s[i]=vowel
            //>>1 is necessary for cases where s[i]!=vowel
            if(seen[cur]==-2) seen[cur]=i;
            ans=Math.max(ans,i-seen[cur]);
        }
        return ans;
    }
}
