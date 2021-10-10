//Tamonash Chakraborty
//O(logn) update 
//O(logn) for query
class StockPrice {
	TreeMap<Integer,Integer> tm;
    PriorityQueue<int[]> max,min;
    public StockPrice() {
        tm=new TreeMap<>();	//will store the [timestamp,price] pairs
        max=new PriorityQueue<>(new Comparator<int[]>() {	//maximum value
            public int compare(int[] o1, int[] o2) {
                if(o1[1]<o2[1]) return 1;
                else return -1;
            }});
        min=new PriorityQueue<>(new Comparator<int[]>() {	//minimum value
            public int compare(int[] o1, int[] o2) {
                if(o1[1]>o2[1]) return 1;
                else return -1;
            }});
    }
    
    public void update(int timestamp,int price) {
        tm.put(timestamp,price);	//map this value
        max.add(new int[]{timestamp,price});	//add the pair to max
        min.add(new int[]{timestamp,price});	//add the pair to min
    }
    
    public int current() {
        int hi=Integer.MAX_VALUE;
        hi=tm.lowerKey(hi);	//maximum timestamp value will be <=1e9, so this should suffice
        return tm.get(hi);
    }
    
    public int maximum() {
        while(tm.get(max.peek()[0])!=max.peek()[1]) max.poll();	//remove all unupdated pairs
        return max.peek()[1];
    }
    
    public int minimum() {
        while(tm.get(min.peek()[0])!=min.peek()[1]) min.poll();	//remove all unupdated pairs
        return min.peek()[1];
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(stock_i);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
