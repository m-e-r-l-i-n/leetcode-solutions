class Solution {
    public int[] countBits(int num) {
        int i,a[]=new int[num+1];
        for(i=1;i<=num;i++)
        a[i]=a[i/2]+i%2;
        return a;
    }
}
