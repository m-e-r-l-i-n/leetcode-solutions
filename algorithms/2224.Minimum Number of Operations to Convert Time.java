//Tamonash Chakraborty
//O(1)
class Solution {
    public int convertTime(String current, String correct) {
        int cor=getTime(correct),cur=getTime(current);
        int diff=cor-cur,ans=diff/60;   //number of times we need to update difference
        diff%=60;
        ans+=diff/15;   //fill greedily
        diff%=15;
        ans+=diff/5;
        ans+=diff%=5;
        return ans;
    }
    
    int getTime(String s)   //convert string to int
    {
        int hr=s.charAt(0)*10+s.charAt(1),min=s.charAt(3)*10+s.charAt(4);
        return hr*60+min;
    }
}
