class Solution {
    public int numSubmat(int[][] mat) {
        int i,j,n=mat.length,m=mat[0].length;
        for(i=0;i<n;i++)
        for(j=m-1;j>=0;j--)
        {
            if(mat[i][j]==0) continue;
            if(j!=m-1) mat[i][j]+=mat[i][j+1]; 
        } 
        int ans=0;
        for(j=0;j<m;j++)  
        { 
            i=n-1; 
            Stack<Pair> q=new Stack<Pair>(); 
            int to_sum=0,c=0; 
            while(i>=0)  
            { 
                c=0; 
  
                while(q.size()!=0 && q.peek().first>mat[i][j])  
                { 
                    to_sum-=(q.peek().second+1)*(q.peek().first-mat[i][j]);
                    c+=q.peek().second+1; 
                    q.pop(); 
                } 
                to_sum+=mat[i][j]; 
                ans+=to_sum; 
                q.add(new Pair(mat[i][j],c)); 
                i--; 
            } 
        }
        return ans;
    }
    
    class Pair
    {
        int first,second;
        Pair(int a,int b)
        {
            first=a; second=b;
        }
    }
}
