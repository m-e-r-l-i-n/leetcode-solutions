class Solution {
    public String generateTheString(int n) {
        String s="";
        int i=0;
        if(n%2==0) 
        {i++; s="a";}
        for(;i<n;i++)
        s=s+"b";     
        return s;
    }
}
