class Solution {
    public int findLucky(int[] arr) {
        int c[]=new int[501],i;
        for(i=0;i<arr.length;i++)
            c[arr[i]]++;
        int max=-1;
        for(i=1;i<=500;i++)
            if(c[i]==i && c[i]>max) max=c[i];
        return max;
    }
}
