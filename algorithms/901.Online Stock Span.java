class StockSpanner {
    Stack<Pair> s;
    public StockSpanner() {
        s=new Stack<>();
    }
    
    public int next(int price) {
        int d=1;
        while(!s.isEmpty() && s.peek().a<=price) d+=s.pop().b;
        s.push(new Pair(price,d));
        return d;
    }
    
    class Pair
    {
        int a,b;
        Pair(int x,int y)
        {
            a=x; b=y;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
