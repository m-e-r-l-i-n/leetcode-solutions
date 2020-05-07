class Solution {
    public String sortString(String s) {
        StringBuilder sb=new StringBuilder();
        int i,c[]=new int[26];
        for(i=0;i<s.length();i++)
            c[s.charAt(i)-97]++;
        while(true)
        {
            int t=0;
            for(i=0;i<26;i++)
                if(c[i]>0)
                {c[i]--; sb.append((char)(97+i));}
                else t++;
            if(t==26) break;
            t=0;
            for(i=25;i>=0;i--)
                if(c[i]>0)
                {c[i]--; sb.append((char)(97+i));}
                else t++;
            if(t==26) break;
        }
        return sb.toString();
    }
}
