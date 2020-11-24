class Solution {
    public int calculate(String s) {
        char c[]=(s+"+0").toCharArray();
        Stack<Integer> num=new Stack<>();
        int n=0; char sign='+';
        for(char i:c)
        {
            if(i==' ') continue;
            if(i>='0' && i<='9') n=10*n+(i-'0');
            else 
            {
                if(sign=='+') num.add(n);
                if(sign=='-') num.add(-n);
                if(sign=='*') num.add(num.pop()*n);
                if(sign=='/') num.add(num.pop()/n);
                sign=i;
                n=0;
            }
        }
        int ans=0;
        while(!num.isEmpty()) ans+=num.pop();
        return ans;
    }
}
