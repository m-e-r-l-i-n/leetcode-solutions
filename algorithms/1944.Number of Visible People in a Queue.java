class Solution {
    public int[] canSeePersonsCount(int[] h) 
    {
        Stack<Integer> s=new Stack<>();
        int i,n=h.length,a[]=new int[n];
        s.add(n-1);
        for(i=n-2;i>=0;i--)
        {
            while(!s.isEmpty() && h[s.peek()]<h[i]) 
            {
                s.pop();
                a[i]++;
            }
            if(!s.isEmpty()) a[i]++;
            s.push(i);
        }
        return a;
    }
}
