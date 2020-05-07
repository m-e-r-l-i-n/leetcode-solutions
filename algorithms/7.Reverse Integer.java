import java.math.*;
class Solution {
    public int reverse(int x) {
        long t=0,no=0;
        if(x<0) t=1;
        x=(int)Math.abs(x);
        while(x>0)
        {
            no=(10*no)+x%10;
            if(no>Integer.MAX_VALUE || no<Integer.MIN_VALUE) return 0;
            x=x/10;
        }
        if(t==0) return (int)no;
        else return (int)-no;        
    }
}
