//Tamonash Chakraborty
//O(log10(num))
class Solution {
    public int largestInteger(int num) {
        //find indices with odd and even values
        Stack<Integer> odd=new Stack<>(), even=new Stack<>();
        int dig[]=new int[10],p10[]=new int[10];  //count the digits, and store powers of 2
        p10[0]=1; int i=0;
        
        while(num>0)
        {
            int d=num%10;
            num/=10;
            dig[d]++;
            if(d%2==0) even.add(i); //add indices
            else odd.add(i);
            if(i+1<10) p10[++i]=p10[i-1]*10;  //store 10^x values
        }
        
        int ans=0,j=9; i=8;
        while(!odd.isEmpty() || !even.isEmpty())
        {
            while(j>0 && dig[j]==0) j-=2;   //there will be positive values somewhere
            while(i>0 && dig[i]==0) i-=2;
            
            //in this case, we need to use the largest odd value we have
            if(even.isEmpty() || (!odd.isEmpty() && odd.peek()<even.peek()))
            {ans+=j*p10[odd.pop()]; dig[j]--;}
            else {ans+=i*p10[even.pop()]; dig[i]--;}    //use the largest even digit here
        }
        return ans;
    }
}
