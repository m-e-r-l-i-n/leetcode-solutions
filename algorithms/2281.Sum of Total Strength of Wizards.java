//Tamonash Chakraborty
//O(n)
class Solution {
    public int totalStrength(int[] strength) {
        int n=strength.length;
        long sum[]=new long[n+1],M=(int)1e9+7;
        int i,a[]=new int[n+1];
        
        for(i=1;i<=n;i++)   
        {
            a[i]=strength[i-1]; //convert to 1 based indexing
            sum[i]=(sum[i-1]+a[i])%M;
        }
        
        int l[]=new int[n+1],r[]=new int[n+1];
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for(i=1;i<=n;i++)
        {
            while(stack.peek()!=0 && a[stack.peek()]>=a[i]) stack.pop();
            l[i]=i-stack.peek();  //count indices with value >=a[i]
            stack.add(i);
        }
        
        while(!stack.isEmpty()) stack.pop();
        stack.add(n+1);
        for(i=n;i>0;i--)   
        {
            while(stack.peek()!=n+1 && a[stack.peek()]>a[i]) stack.pop();
            r[i]=stack.peek()-i;    //count indices with value <a[i]
            stack.add(i);
        }
        
        long ans=0;
        long sum2[]=new long[n+1];
        for(i=1;i<=n;i++) sum2[i]=(sum2[i-1]+sum[i])%M;
        for(i=1;i<=n;i++)
        {
            /*
            *sum of subarrays with min=a[i] 
            *sum((all of i to i+r[i]-1) from (all of i-l[i]+1 to i))
            */
            long cur=(sum2[i+r[i]-1]-sum2[i-1]+M)*l[i]%M;
            cur-=(sum2[i-1]-sum2[Math.max(0,i-l[i]-1)]+M)*r[i]%M;
            cur=(cur+M)*a[i]%M;
            ans=(ans+cur)%M;
        }
        return (int)ans;
    }
}
