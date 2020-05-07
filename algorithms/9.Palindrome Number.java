class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int no=0,n=x;
        while(x>0)
        {
            no=(10*no)+x%10;
            x/=10;
        }
        if(no==n) return true;
        else return false;        
    }
}
