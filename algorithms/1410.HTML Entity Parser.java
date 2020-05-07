class Solution {
    public String entityParser(String text) {
        int i,n=text.length(); char c[]=text.toCharArray();
        String s=""; boolean clear=false;
        for(i=0;i<n;i++)
            if(c[i]=='&' && clear==false)
            {
                int j,l=0; String st2="";
                while(i+l<text.length() && text.charAt(i+l)!=';') l++;
                if(i+l==text.length()) clear=true;
                if(clear) 
                {
                    for(j=i;j<n;j++)
                    s=s+c[j]; 
                    break;
                }
                for(j=i;j<i+l;j++)
                st2+=c[j];
                
                if(st2.equals("&quot")) s+="\"";
                else if(st2.equals("&apos")) s+="\'";
                else if(st2.equals("&amp")) s+="&";
                else if(st2.equals("&gt")) s+=">";
                else if(st2.equals("&lt")) s+="<";
                else if(st2.equals("&frasl")) s+="/";
                else s+=st2+";";
                i+=l;
            }
            else s=s+c[i];
        return s;
    }
}
