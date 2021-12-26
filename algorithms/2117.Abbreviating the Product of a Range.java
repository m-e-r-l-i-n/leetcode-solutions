//Tamonash Chakraborty
//O(n*log10(n))
class Solution {
    public String abbreviateProduct(int left, int right) {
        //count zeros first
        int i,M=100000,five=0,two=0,x;
        long p=1,prod=1;
        boolean red=false;  //do we need to abbreviate product?
        for(i=left;i<=right;i++)    //trailing zeros depend on fives and twos
        {
            x=i;
            while(x%5==0) {five++; x/=5;}
            while(x%2==0) {two++; x/=2;}
        }

        int z=Math.min(two,five);
        two=z; five=z;
        //find the last 5 non zero digits
        for(i=left;i<=right;i++)
        {
            x=i;
            while(x%5==0 && five>0) {five--; x/=5;} //removing zeros
            while(x%2==0 && two>0) {two--; x/=2;}
            p=(p*x)%M;

            if(!red)
            {
                prod*=x;
                if(Long.toString(prod).length()>10) red=true;
            }
        }
        if(!red) return ""+prod+"e"+z;  //no need of anything

        String last=Long.toString(p);    //these are our last 5 values
        while(last.length()<5) last="0"+last;	//add necessary zeros
        double fi=1;
        //now for the first 5 values
        for(i=right;i>=left;i--)
        {
            fi*=i;
            while(fi>=10) fi/=10;   //x.xxx format no need to use log, precision issues may happen
        }
        M/=10;
        long fir=(long)(fi*M);  //we need 4 digits after the .
        return ""+fir+"..."+last+"e"+z;
    }
}
