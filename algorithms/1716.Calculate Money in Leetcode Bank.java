class Solution {
    public int totalMoney(int n) {
        int i=0,add=1,amt=0;
        while(n>0)
        {
            amt+=i+add;
            add++;
            if(add==8)
            {
                add=1;
                i++;
            }
            n--;
        }
        return amt;
    }
}
