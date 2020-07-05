class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int i,d=arr[1]-arr[0];
        for(i=2;i<arr.length;i++)
        if(arr[i]-arr[i-1]!=d) return false;
        return true;
    }
}
