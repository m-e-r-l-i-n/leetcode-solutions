class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s1=new Stack<>();
        Stack<Character> s2=new Stack<>();
        char s[]=S.toCharArray(), t[]=T.toCharArray();
        int i=0,j=0; boolean flag=true;
        while(i<s.length)
        {
            if(s[i]=='#')
            {
                if(!s1.isEmpty()) s1.pop();
                i++;
            }
            else s1.push(s[i++]);
            
        }
        while(j<t.length)
        {
            if(t[j]=='#')
            {
                if(!s2.isEmpty()) s2.pop();
                j++;
            }
            else  s2.push(t[j++]);
        }
        
        while(!s1.isEmpty() && !s2.isEmpty())
        if(s1.pop()!=s2.pop()) {flag=false; break;}
        if(s1.size()!=s2.size()) flag=false;
        return flag;
    }
}
