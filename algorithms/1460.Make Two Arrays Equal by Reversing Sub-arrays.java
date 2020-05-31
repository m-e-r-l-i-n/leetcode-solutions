class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int c1[]=new int[1001],c2[]=new int[1001],i;
        for(i=0;i<arr.length;i++)
        {
            c1[arr[i]]++;
            c2[target[i]]++;
        }    
        for(i=0;i<=1000;i++)
        if(c1[i]!=c2[i]) return false;
        return true;
    }
}
