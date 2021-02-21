class Solution {
    public String mergeAlternately(String w1, String w2) {
        StringBuilder sb=new StringBuilder();
        int i=0,j=0,t=0;
        while(i<w1.length() && j<w2.length())
        {
            if(t==0) sb.append(w1.charAt(i++));
            else sb.append(w2.charAt(j++));
            t^=1;
        }
        while(i<w1.length()) sb.append(w1.charAt(i++));
        while(j<w2.length()) sb.append(w2.charAt(j++));
        return sb.toString();
    }
}
