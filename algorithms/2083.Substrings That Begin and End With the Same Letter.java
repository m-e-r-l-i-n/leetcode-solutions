//Tamonash Chakraborty
//O(n)

class Solution {
    public long numberOfSubstrings(String s) {
        int c[]=new int[26],i,n=s.length();
        long ans=0;
        //compute frequency
        for(i=0;i<n;i++) c[s.charAt(i)-'a']++;
        
        //count pairs
        for(i=0;i<n;i++) ans=(ans+c[s.charAt(i)-'a']--);
        //note that if there are x a's for the 1st a, there will be x ends, for 2nd, (x-1) a's...
        return ans;
    }
}
