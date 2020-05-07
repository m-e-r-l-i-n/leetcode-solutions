class Solution {
    public boolean isValid(String s) {
        int i,l=s.length();
        if(l==0) return true;
        if(l%2==1) return false;
        Stack<Character> st=new Stack<>();
        for(i=0;i<l;i++)
        {
            char c=s.charAt(i);
            if (c=='(' || c=='[' || c=='{') st.push(c); 
            else
            {
                if(st.isEmpty()) return false;
                if(c==')' && st.peek()!='(') return false;
                if(c==']' && st.peek()!='[') return false;
                if(c=='}' && st.peek()!='{') return false;
                st.pop();
            }
            
        }    
        return st.isEmpty();
    }
}
