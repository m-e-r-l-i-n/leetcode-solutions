//Tamonash Chakraborty
//O(nlogn)
class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int i,n=nums.length;
        a=new int[2][n];    //we could use [n][2], but in this way, it will be more efficient
        t=new int[2][n];    //0 for original elements, 1 for mapped
        
        //991-669, 338-007 38-07
        for(i=0;i<n;i++)
        {
            int x=nums[i],d,map=0,p10=1;
            while(x>0)
            {
                d=x%10;
                map+=p10*mapping[d];
                p10*=10;
                x/=10;
            }
            if(nums[i]==0) map=mapping[0];  //corner case
            
            a[0][i]=nums[i];
            a[1][i]=map;
        }
        
        merge_sort(0,n-1);
        return a[0];
    }
    
    int a[][],t[][];
    void merge_sort(int l,int r)    //perform merge sort
    {
        if(l>=r) return;
        
        int m=(l+r)/2;
        merge_sort(l,m);
        merge_sort(m+1,r);
        merge(l,m,r);
    }
    
    void merge(int l,int m,int r)   //merge ranges in sorted order. Keep relative ordering
    {
        int i=l,j=m+1,k=0;
        while(i<=m && j<=r)
        {
            if(a[1][i]<=a[1][j]) {t[0][k]=a[0][i]; t[1][k++]=a[1][i++];}
            else {t[0][k]=a[0][j]; t[1][k++]=a[1][j++];}
        }
        
        while(i<=m) {t[0][k]=a[0][i]; t[1][k++]=a[1][i++];}
        while(j<=r) {t[0][k]=a[0][j]; t[1][k++]=a[1][j++];}
        i=l; j=0;
        while(i<=r) {a[0][i]=t[0][j]; a[1][i++]=t[1][j++];}
    }
}
