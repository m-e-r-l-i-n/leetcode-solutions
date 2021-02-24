class Solution {
    public int scoreOfParentheses(String S) {
        int cur=0,i;
        Stack<Integer> s=new Stack<>();
        for(i=0;i<S.length();i++)
        {
            char c=S.charAt(i);
            if(c=='(') 
            {
                s.push(cur);
                cur=0;
            } 
            else cur=s.pop()+Math.max(cur*2,1);
        }
        return cur;
    }
}
