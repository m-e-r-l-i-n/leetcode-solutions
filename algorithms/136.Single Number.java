class Solution {
    public int singleNumber(int[] num) {
        int i,x=0;
        for(i=0;i<num.length;i++)
            x^=num[i];
        return x;
    }
}
