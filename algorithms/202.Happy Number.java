class Solution 
{
    public boolean isHappy(int n) 
    {
        int i,flag=0;
        n=sumd(n);
        while(present(n)==false)
        {
            n=sumd(n);
            if(n==1) {flag=1; break;}
        }
        if(flag==0) return false;
        else return true;
    }
    
    boolean present(int n)
    {
        int i,a[]={4,16,20,37,42,58,89,145};	//this is the loop in which numbers will keep on moving when the happy condition for 1 is false
        for(i=0;i<8;i++)
            if(a[i]==n) return true;
        return false;
    }
    
    int sumd(int n)	//returns sum of squares of digits
    {
        int no=0;
        while(n>0)
        {
            no+=(n%10)*(n%10);
            n/=10;
        }
        return no;
    }
}
