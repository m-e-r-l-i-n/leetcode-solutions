//Tamonash Chakraborty
//O(n)
class Solution {
    public int minSteps(String s, String t) {
        int c[]=new int[26],i;
        for(i=0;i<s.length();i++) c[s.charAt(i)-'a']++; //add characters
        for(i=0;i<t.length();i++) c[t.charAt(i)-'a']--; //remove common characters
        
        int ans=0;
        for(int x:c) ans+=Math.abs(x);    //only the diff characters should be considered
        return ans;
    }
}
