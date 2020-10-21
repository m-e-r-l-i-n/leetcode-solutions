class Solution {
    public int[] asteroidCollision(int[] a) 
    {
        if(a.length<=1) return a; 
        Stack<Integer> s=new Stack<>();
        for(int i:a) 
        {
            if(i>0) s.push(i);
            else
            {
                while(!s.isEmpty() && s.peek()>0 && Math.abs(s.peek())<Math.abs(i)) s.pop();
                if(s.isEmpty() || s.peek()<0) s.push(i);
                else if(s.peek()==Math.abs(i)) s.pop();
            }
        }
        
        int i,ans[]=new int[s.size()];
        for (i=ans.length-1;i>=0; i--) ans[i]=s.pop();
        return ans;
    }
}
