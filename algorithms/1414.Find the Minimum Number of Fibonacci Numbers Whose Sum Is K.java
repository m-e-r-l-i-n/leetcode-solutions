class Solution {
    public int findMinFibonacciNumbers(int k) {
        ArrayList<Integer> fibo=new ArrayList<>();
        fibo.add(0); fibo.add(1);
        int i=2,next=0;
        while(true)
        {
            next=fibo.get(i-1)+fibo.get(i-2);
            if(next>k) break;
            fibo.add(next);
            i++;
        }
        int c=0; i--;
        while(k!=0)
        {
            c+=k/fibo.get(i);
            k%=fibo.get(i);
            i--;
        }
        return c;
    }
}
