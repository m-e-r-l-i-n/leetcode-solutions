class Solution {
    public int minSteps(String s, String t) {
        int c[]=new int[26],i,n=s.length();
        for(i=0;i<n;i++) 
        {
            c[s.charAt(i)-'a']++;
            c[t.charAt(i)-'a']--;
        }
        
        int ans=0;
        for(i=0;i<26;i++) ans+=Math.abs(c[i]);
        return ans/2;
    }
}
