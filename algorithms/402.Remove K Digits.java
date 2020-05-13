class Solution {
    public String removeKdigits(String num, int k) {
        if(k==0) return num;
        if(k==num.length()) return "0";
        
        Stack<Character> s=new Stack<>();
        int i;
        for(i=0;i<num.length();i++)
        {
            while(!s.isEmpty() && k>0 && s.peek()>num.charAt(i)) 
            {s.pop(); k--;}
            s.push(num.charAt(i));
        }
        for(i=0;i<k;i++) s.pop();
        StringBuilder sb=new StringBuilder();
        while(!s.isEmpty()) sb.append(s.pop());
        sb.reverse();
        while(sb.length()>1 && sb.charAt(0)=='0') sb.deleteCharAt(0);
        return sb.toString();
    }
}
