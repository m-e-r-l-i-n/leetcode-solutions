class Solution {
    public int[] findDiagonalOrder(int[][] a) {
        if(a.length==0 || a[0].length==0) return new int[0];        //irritating tc
        
        int n=a.length,m=a[0].length,ans[]=new int[n*m],i=0,j=0,k=0;
        for(k=0;k<n*m;k++) 
        {
            ans[k]=a[i][j];
            if((i+j)%2==0) 
            { 
                if(j==m-1) i++;
                else if(i==0) j++;
                else {i--; j++;}
            } 
            else 
            {
                if(i==n-1) j++;
                else if(j==0) i++;
                else {i++; j--;}
            }   
        }   
        return ans;
    }
}
