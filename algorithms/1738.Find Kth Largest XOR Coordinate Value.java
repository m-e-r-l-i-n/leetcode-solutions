class Solution {
    public int kthLargestValue(int[][] a, int k) {
        int n=a.length,m=a[0].length,i,j;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(i=0;i<n;i++)
        for(j=0;j<m;j++)
        if(j!=0) a[i][j]^=a[i][j-1];
        for(i=0;i<m;i++)
        for(j=0;j<n;j++) 
        {
            if(j>0) a[j][i]^=a[j-1][i];
            pq.add(a[j][i]);    
        }
        
            
        k=n*m-k+1;
        int ans=0;
        while(k>0)
        {
            ans=pq.poll();
            k--;
        }
        return ans;
    }
}
