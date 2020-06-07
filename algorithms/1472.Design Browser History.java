class BrowserHistory{

    ArrayList<String> al=new ArrayList<>();
    int l,max;
    public BrowserHistory(String homepage) {
        al.add(homepage);
        l=0; max=1;
    }
    
    public void visit(String url) {
        al.add(++l,url);
        max=l+1;
        //System.out.println(al+" "+l+" "+max);
    }
    
    public String back(int steps) {
        int i=Math.max(l-steps,0);
        l=i;
        //System.out.println(al+" "+l);
        return al.get(l);
    }
    
    public String forward(int steps) {
        int i=Math.min(max-1,l+steps);
        l=i;
        //System.out.println(al+" "+l+" "+max);
        return al.get(l);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
