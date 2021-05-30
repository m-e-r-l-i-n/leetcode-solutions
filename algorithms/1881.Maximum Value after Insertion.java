class Solution {
    public String maxValue(String n, int x) {
        if(n.charAt(0)=='-') return "-"+max(n.substring(1),(char)(x+'0'),1).toString();
        return max(n,(char)(x+'0'),0).toString();
    }
    
    StringBuilder max(String s,char d,int ty)
    {
        int i,n=s.length();
        StringBuilder sb=new StringBuilder();
        for(i=0;i<n;i++)
        if(ty==0)
        {
            if(s.charAt(i)>=d) sb.append(s.charAt(i));
            else
            {
                sb.append(d);
                int j=i;
                while(j<n) sb.append(s.charAt(j++));
                return sb;
            }
        }
        else
        {
            if(s.charAt(i)<=d) sb.append(s.charAt(i));
            else
            {
                sb.append(d);
                int j=i;
                while(j<n) sb.append(s.charAt(j++));
                return sb;
            }
        }
        sb.append(d);
        return sb;
    }
    
}
