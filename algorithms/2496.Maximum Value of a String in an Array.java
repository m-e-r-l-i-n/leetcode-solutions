//Tamonash Chakraborty
//O(n)
class Solution {
    public int maximumValue(String[] s) {
        int ans=0;
        for(String x:s)
        {
            int i,num=0,l=x.length(),value=l;
            for(i=0;i<l;i++)
            if(x.charAt(i)>='0' && x.charAt(i)<='9') num=10*num+x.charAt(i)-'0';
            else break;
            
            if(i==l) value=num;
            ans=Math.max(ans,value);
        }
        return ans;
    }
}
