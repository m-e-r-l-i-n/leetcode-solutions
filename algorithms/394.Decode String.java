class Solution {
    public String decodeString(String s) {
        String ans="";
        Stack<Integer> c=new Stack<>();
        Stack<String> res=new Stack<>();
        int i;
        for(i=0;i<s.length();) 
        {
            char ch=s.charAt(i);
            if(ch>='0' && ch<='9') 
            {
                int cur=0;
                while(ch>='0' && ch<='9') 
                {
                    cur=10*cur+(ch-'0');
                    ch=s.charAt(++i);
                }
                c.push(cur);
            }
            else if(ch=='[') 
            {
                res.push(ans);
                ans="";
                i++;
            }
            else if(ch==']') 
            {
                StringBuilder temp=new StringBuilder(res.pop());
                int rep=c.pop(),j;
                for(j=0;j<rep;j++) temp.append(ans);
                ans=temp.toString();
                i++;
            }
            else 
            {
                ans+=ch;
                i++;
            }
        }
        return ans;
    }
}
