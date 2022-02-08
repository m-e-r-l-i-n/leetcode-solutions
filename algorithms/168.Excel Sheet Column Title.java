class Solution {
    public String convertToTitle(int columnNumber) {
        long p=26,sum=0;
        while(sum+p<columnNumber) 
        {
            sum+=p;
            p*=26;
        }
        columnNumber-=sum; //remove columns with smaller length
        Queue<Integer> q=new LinkedList<>();
     
        int i;
        while(p>0)
        {
            p/=26;
            for(i=1;i<=26;i++)
            if(p*i>=columnNumber)   //this means the current character is here 
            {
                columnNumber-=p*(i-1);
                q.add(i-1);
                break;
            }
        }
        
        StringBuilder ans=new StringBuilder();
        while(!q.isEmpty()) ans.append((char)('A'+q.poll()));
        return ans.toString();
    }
}
