class Solution {
    public int findComplement(int num) {
        int n=(int)(Math.log(num)/Math.log(2)),i,c=0;
        for(i=0;i<=n;i++)
            if(((num>>i)&1)==0) c+=(int)Math.pow(2,i);
        return c;
    }
}
