class Solution {
    public char findTheDifference(String s, String t) {
        int i,x=t.charAt(0);
        for(i=0;i<s.length();i++)
        {
            x^=s.charAt(i);
            x^=t.charAt(i+1);
        }
        return (char)x;
    }
}
