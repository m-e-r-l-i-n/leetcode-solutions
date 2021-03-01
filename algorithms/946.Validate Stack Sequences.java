class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length==0) return true;
        Stack<Integer> s=new Stack<>();
        int i,j=0;
        for(i=0;i<pushed.length;i++)
        {
            s.push(pushed[i]);
            while(!s.isEmpty() && s.peek()==popped[j])
            {
                s.pop();
                j++;
                if(j==popped.length) return true;
            }
        }    
        return false;
    }
}
