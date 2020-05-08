class Solution {
    public int countElements(int[] arr) {
        int i,n=arr.length,co=0,c[]=new int[1002],max=0;
        for(i=0;i<n;i++)
        {
            c[arr[i]]++;
            if(arr[i]>max) max=arr[i];
        }
        for(i=0;i<=max;i++)
            if(c[i+1]!=0)
            co+=c[i];
        return co;
    }
}
