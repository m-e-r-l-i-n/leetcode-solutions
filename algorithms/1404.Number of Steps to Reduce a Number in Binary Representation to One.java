class Solution {
    public int numSteps(String s) {
        if(s.equals("1")) return 0;
        int c=0;
        while(s.equals("1")==false)
        {
            c++;
            if(s.charAt(s.length()-1)=='0')
                s=s.substring(0,s.length()-1);
            else
            {
                String st="";int i,carry=1;
                for(i=s.length()-1;i>=0;i--)
                if(s.charAt(i)=='1' && carry==1)
                st="0"+st; 
                else if(s.charAt(i)=='1' && carry==0)
                st="1"+st; 
                else if(s.charAt(i)=='0' && carry==0)
                st="0"+st;
                else if(s.charAt(i)=='0' && carry==1)
                {st="1"+st;carry=0;}
                if(carry==1) st="1"+st;
                s=st;
            }
        }
        return c;
        
    }
}
