class Solution {
    public boolean isIdealPermutation(int[] a) {
        int i,max=-1;
        for(i=0;i+2<a.length;i++)
        {
            max=Math.max(max,a[i]);
            if(max>a[i+2]) return false;
        }
        return true;
    }
}
