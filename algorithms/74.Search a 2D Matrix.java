class Solution {
    public boolean searchMatrix(int[][] m, int target) {
        if(m.length==0 || m[0].length==0) return false;
        int row=rowsearch(m,target);
        if(row<0) return false;
        return colsearch(m,row,target);
    }
    
    int rowsearch(int a[][],int k)
    {
        int l=0,r=a.length-1,m=a[0].length-1,mid;
        if(k<a[0][0] || k>a[r][m]) return -1;
        while(l<=r)
        {
            mid=(l+r)/2;
            if(k>=a[mid][0] && k<=a[mid][m]) return mid;
            else if(k>a[mid][m]) l=mid+1;
            else r=mid-1;
        }
        return -1;
    }
    
    boolean colsearch(int a[][],int i,int k)
    {
        int l=0,r=a[0].length-1,mid;
        while(l<=r)
        {
            mid=(l+r)/2;
            if(a[i][mid]==k) return true;
            else if(a[i][mid]>k) r=mid-1;
            else l=mid+1;
        }
        return false;
    }
}
