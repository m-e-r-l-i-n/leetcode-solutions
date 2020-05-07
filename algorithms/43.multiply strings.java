class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        int i,j,sum=0;
        int res[]=new int[num1.length()+num2.length()-1];
        for(i=0;i<num1.length();i++)   
        {
            int a=(int)(num1.charAt(i)-'0');
            for(j=0;j<num2.length();j++)
                res[i+j]+=a*(int)(num2.charAt(j)-'0');
        }
        
        for(i=res.length-1;i>0;i--)
        {
            res[i-1]+=res[i]/10;
            res[i]%=10;
        }
        
        StringBuilder sb=new StringBuilder();
        for(i=0;i<res.length;i++)
            sb.append(res[i]);
        
        return sb.toString();
        
    }
}
