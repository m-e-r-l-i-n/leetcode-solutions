class Solution {
    public boolean checkValidString(String s) {
        char c[]=s.toCharArray();
        int i;
        Stack<Integer> st=new Stack<>();
        Stack<Integer> e=new Stack<>();
        for(i=0;i<c.length;i++)
        {
            if(c[i]=='(') st.push(i);
            else if(c[i]=='*') e.push(i);
            else
            {
                if(!st.isEmpty()) st.pop();
                else if(!e.isEmpty()) e.pop();
                else return false;
            }
        }
        
        while(!st.isEmpty() && !e.isEmpty())
            if(st.pop()>e.pop()) return false;
        return st.isEmpty();
    }
}
