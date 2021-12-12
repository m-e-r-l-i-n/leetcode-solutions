//Tamonash Chakraborty
//O(n)
class Solution {
    public long subArrayRanges(int[] a) 
    {
        int n=a.length,i;
        long max[]=new long[n],min[]=new long[n],M=(int)1e9+7;
        Stack<Integer> st=new Stack<>();
       
        //count number of subarrays for which an item is maximum
        st.add(-1);
        for(i=0;i<n;i++)
        {
            while(st.peek()!=-1 && a[st.peek()]<=a[i]) st.pop();
            max[i]=i-st.peek(); //number of elements to left
            st.add(i);
        }
        while(!st.isEmpty()) st.pop();
        st.add(n);
        for(i=n-1;i>=0;i--)
        {
            while(st.peek()!=n && a[st.peek()]<a[i])    //do not recount subarrays
            st.pop();
            max[i]*=st.peek()-i;
            st.add(i);
        }
        
        //count number of subarrays for which an item is minimum 
        while(!st.isEmpty()) st.pop();
        st.add(-1);
        for(i=0;i<n;i++)
        {
            while(st.peek()!=-1 && a[st.peek()]>=a[i]) st.pop();
            min[i]=i-st.peek();
            st.add(i);
        }
        while(!st.isEmpty()) st.pop();
        st.add(n);
        for(i=n-1;i>=0;i--)
        {
            while(st.peek()!=n && a[st.peek()]>a[i])
            st.pop();
            min[i]*=st.peek()-i;
            st.add(i);
        }
        
        long ans=0;
        for(i=0;i<n;i++)    //add maxima and subtract minima
        ans=(ans+(max[i]-min[i])*a[i]);
        return ans;
    }
}
