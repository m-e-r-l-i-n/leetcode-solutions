/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix b) {
        int i,j=0,r=0,c=0,in=-1;
        List<Integer> dim=b.dimensions();
        r=dim.get(0); c=dim.get(1);
        i=0; j=c-1; 
        while((i>=0 && i<r) && (j>=0 && j<c))
        {
            int p=b.get(i,j);
            if(p==0) i++;
            else {in=j;j--;}
        }
        return in;
    }
}
