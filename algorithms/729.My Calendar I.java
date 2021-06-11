class MyCalendar {
    TreeMap<Integer, Integer> tm;
    public MyCalendar() 
    {
        tm=new TreeMap<>();
    }

    public boolean book(int s, int e) 
    {
        Integer f=tm.floorKey(s);
        if(f!=null && tm.get(f)>s) return false;
        Integer c=tm.ceilingKey(s);
        if(c!= null && c<e) return false;

        tm.put(s,e);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
