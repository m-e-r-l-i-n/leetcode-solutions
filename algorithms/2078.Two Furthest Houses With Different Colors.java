//Tamonash Chakraborty
//O(n^2)
class Solution {
    public int maxDistance(int[] colors) {
        int i,j,n=colors.length;
        for(i=n-1;i>0;i--)
        for(j=0;j+i<n;j++)
        if(colors[j]!=colors[j+i]) return i;
        return -1;	//never reached
    }
}
