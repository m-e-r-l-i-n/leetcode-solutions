class Solution {
    public int romanToInt(String s) {
        int val=0,i;        
        for(i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='I') val++;
            if(s.charAt(i)=='V') val+=5;
            if(s.charAt(i)=='X') val+=10;
            if(s.charAt(i)=='L') val+=50;
            if(s.charAt(i)=='C') val+=100;
            if(s.charAt(i)=='D') val+=500;
            if(s.charAt(i)=='M') val+=1000;
        }
        
        if(s.contains("IV")) val-=2;
        if(s.contains("IX")) val-=2;
        if(s.contains("XL")) val-=20;
        if(s.contains("XC")) val-=20;
        if(s.contains("CD")) val-=200;
        if(s.contains("CM")) val-=200;
        
        return val;
    }
}
