class Solution {
    public int minOperations(String[] logs) {
        int i;
        Stack<Integer> s=new Stack<>();
        for(i=0;i<logs.length;i++)
        {
            if(logs[i].equals("./")) continue;
            else if(logs[i].equals("../")) 
            {
                if(!s.isEmpty()) s.pop();
            }
            else s.push(i);
        }
        return s.size();
    }
}
