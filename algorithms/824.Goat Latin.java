class Solution {
    public String toGoatLatin(String s) {
        StringBuilder sb=new StringBuilder();
        String st[]=s.split(" ");
        String cur="a";
        for(String x:st)
        {
            char c=x.charAt(0);
            if(consonant(c)) 
            {
                sb.append(x.substring(1));
                sb.append(c);
            }
            else sb.append(x);
            sb.append("ma");
            sb.append(cur);
            cur+='a';
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    
    static boolean consonant(char c)
    {
        if(c>='A' && c<='Z') c=(char)(c+32);
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') return false;
        else return true;
    }
}
