class Solution {
    public int longestValidParentheses(String s) {
        int n=s.length(),ans=0,i;
        Stack<Integer> st=new Stack<>();
        for(i=0;i<n;i++)
        if(s.charAt(i)=='(') st.push(i);
        else
        {
            if(!st.isEmpty())
            {
                if(s.charAt(st.peek())=='(') st.pop();
                else st.push(i);
            }
            else st.push(i);
        }
        if(st.isEmpty()) ans=n;
        else 
        {
            int a=n,b=0;
            while(!st.empty()) 
            {
                b=st.pop();
                ans=Math.max(ans,a-b-1);
                a=b;
            }
            ans=Math.max(ans,a);
        }
        return ans;
    }
}
