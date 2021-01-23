class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int c[]=new int[100],n=mat.length,m=mat[0].length,i,j;
        for(i=n-1;i>=0;i--)
        {
            int x=i,y=0;
            ArrayList<Integer> al=new ArrayList<>();
            while(x<n && y<m) al.add(mat[x++][y++]);
            Collections.sort(al);
            x=i; y=0; j=0;
            while(x<n && y<m) mat[x++][y++]=al.get(j++);
        }    
        
        for(i=1;i<m;i++)
        {
            int x=0,y=i;
            ArrayList<Integer> al=new ArrayList<>();
            while(x<n && y<m) al.add(mat[x++][y++]);
            Collections.sort(al);
            x=0; y=i; j=0;
            while(x<n && y<m) mat[x++][y++]=al.get(j++);
        }
        return mat;
    }
    
}
