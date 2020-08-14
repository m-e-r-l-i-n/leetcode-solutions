class Solution {
    public int longestPalindrome(String s) {
        int c[]=new int[128],i,l=0;
        boolean one=false;
        for(i=0;i<s.length();i++)
        c[s.charAt(i)]++;
        for(i=0;i<128;i++)
        {
            if(c[i]%2==1) one=true;
            l+=c[i]-c[i]%2;
        }
        if(one) l++;
        return l;
    }
}
