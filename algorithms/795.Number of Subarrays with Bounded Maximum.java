class Solution {
    public int numSubarrayBoundedMax(int[] a, int l, int r) {
        Stack<Integer> s=new Stack<>();
        s.add(-1);
        int i,n=a.length,x[]=new int[n],ans=0;
        for(i=0;i<n;i++)
        if(a[i]<l || a[i]>r) s.add(i);
        else
        {
            while(s.peek()!=-1 && a[s.peek()]<=a[i]) s.pop();
            x[i]=i-s.peek();
            ans+=x[i];
            s.add(i);
        }
        
        s=new Stack<>();
        s.add(n);
        for(i=n-1;i>=0;i--)
        if(a[i]<l || a[i]>r) s.add(i);
        else
        {
            while(s.peek()!=n && a[s.peek()]<a[i]) s.pop();
            ans-=x[i];
            x[i]*=s.peek()-i;
            ans+=x[i];
            s.add(i);
        }
        return ans;
    }
}
