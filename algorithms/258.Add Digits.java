class Solution {
    public int addDigits(int n) {
        //formula for digital root=n-(b-1)*Math.floor((n-1)/(b-1)) where b is base(here 10)
        return n-9*((n-1)/9);
    }
}
