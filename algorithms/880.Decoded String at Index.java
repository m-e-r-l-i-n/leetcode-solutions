class Solution {
    public String decodeAtIndex(String s, int k) 
    {
        long n=0; int i;
        for(i=0;n<k;i++)
        if(s.charAt(i)>='0' && s.charAt(i)<='9') n*=s.charAt(i)-'0';
        else n++;
        while(i>0)
        {
            i--;
            if(s.charAt(i)>='0' && s.charAt(i)<='9') {n/=s.charAt(i)-'0'; k%=n;}
            else if(k%n--==0) return ""+s.charAt(i);
        }
        return "not reached";
    }
}
