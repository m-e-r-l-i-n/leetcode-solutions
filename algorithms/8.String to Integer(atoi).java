class Solution {
    public int myAtoi(String s) {
        s=s.trim();
        if(s.equals("")) return 0;
        char c=s.charAt(0);
        if(!(c==' ' || c=='-' || c=='+' || (c>='0' && c<='9'))) return 0;
        StringBuilder sb=new StringBuilder();
        int i,start=0,end=0;
        char ch[]=s.toCharArray();
        for(i=0;i<s.length();i++)
            if(ch[i]=='+' || ch[i]=='-' || (ch[i]>='0' && ch[i]<='9')) {start=i; break;}
        for(i=start+1;i<s.length();i++)
            if(ch[i]<'0' || ch[i]>'9') {end=i; break;}
        if(end==0) end=i;
        for(i=start;i<end;i++)
        sb.append(ch[i]);
        String st=sb.toString();
        if(st.equals("") || st.length()==1 && (st.charAt(0)<'0' || st.charAt(0)>'9')) return 0;
        int x=0; boolean neg=st.charAt(0)=='-'?true:false;
        try
        {
            x=Integer.parseInt(st);
            return x;
        }
        catch(NumberFormatException e)
        {
            if(neg) return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }
    }
}
