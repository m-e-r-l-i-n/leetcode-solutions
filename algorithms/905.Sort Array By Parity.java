class Solution {
    public int[] sortArrayByParity(int[] a) {
        int i=0,j=a.length-1;
        while(i<j)
        {
            if(a[i]%2==1)
            {
                while(j>i && a[j]%2==1) j--;
                if(j>i) a[j]=a[j]^a[i]^(a[i]=a[j]);
            }
            i++;
        }
        return a;
    }
}
