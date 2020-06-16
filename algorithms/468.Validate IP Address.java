class Solution 
{
    public String validIPAddress(String IP)
    {
        boolean fail=false;
        if(IP.indexOf(".")>0 && !IP.startsWith(".") && !IP.endsWith("."))
        {
            String[] parts=IP.split("\\.");
            if(parts.length==4)
            {
                for(String p:parts)
                {
                    for(char c:p.toCharArray())
                    if(!Character.isDigit(c)) fail=true;
                    if(fail) break;
                    if(p.length()==0 || p.length()>3 || (p.charAt(0)=='0' && p.length()>1) || Integer.valueOf(p)>=256) fail=true;
                    if(fail) break;
                }
                if(!fail) return "IPv4";
            }
        }
        else if(IP.indexOf(":")>0 && !IP.startsWith(":") && !IP.endsWith(":"))
        {
            String[] parts=IP.split(":");
            if(parts.length==8)
            {
                for(String p:parts)
                {
                    for(char c:p.toCharArray())
                    if((!Character.isDigit(c) && !Character.isLetter(c)) || (c>='G' && c<='Z') || (c>='g' && c<='z')) fail=true;
                    if(p.length()==0 || p.length()>4) fail=true;
                    if(fail) break;
                }
                if(!fail) return "IPv6";
            }
        }
        return "Neither";
    }
}
