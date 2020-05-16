class Solution {
    public int maxPower(String s) {
        char c=s.charAt(0);
        int max=1,cur=1,i;
        for(i=1;i<s.length();i++)
        if(s.charAt(i)==c) cur++;
        else
        {
            if(cur>max) max=cur;
            c=s.charAt(i);
            cur=1;
        }
        if(cur>max) max=cur;
        return max;
    }
}
