//Tamonash Chakraborty
//O(N*10^N) where N<6
class Solution {
    public long kMirror(int k, int n) {
        long sum=0; int c=0,i;
        for(i=1;i<=9;i++)   //single digit numbers
        {
            if(palindrome(i,k))
            {
                c++;
                sum+=i;
            }
            if(c==n) return sum;
        }
        
        int pwr=1,q[]=new int[200000];
        while(true) //choose an arbitrary large value
        {
            int prev=pwr,next=pwr*10,rev,j=0; pwr=next;
            long v;
            for(i=prev;i<next;i++)
            {
                //count k-mirrors with x*2 digits
                rev=reverse(i); v=1l*next*i+rev;
                q[j++]=rev; //store the reverses
                if(palindrome(v,k)) {c++; sum+=v;}
                if(c==n) return sum;
            }
            
            j=0;
            for(i=prev;i<next;i++)
            {
                //k-mirrors with x*2+1 digits
                rev=q[j++];   //prevent calculating same values twice
                for(int l=0;l<10;l++)
                {
                    v=1l*next*10*i+l*next+rev;
                    if(palindrome(v,k)) {c++; sum+=v;}
                    if(c==n) return sum;
                }
            }
        }
    }
    
    int reverse(int n)  //reverse a number
    {
        int x=0;
        while(n>0)
        {
            x=10*x+n%10;
            n/=10;
        }
        return x;
    }
    
    int c[]=new int[50];
    boolean palindrome(long n,int b)    //check if number is palindrome in base b
    {
        int i=0;
        while(n>0)
        {
            c[i++]=(int)(n%b);
            n/=b;
        }
        int l=i;
        for(i=0;i<l;i++)
        if(c[i]!=c[l-1-i]) return false;
        return true;
    }
}
