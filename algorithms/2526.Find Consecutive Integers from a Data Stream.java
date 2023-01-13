class DataStream {

    int value,k,c;
    public DataStream(int value, int k) {
        this.value=value;
        this.k=k;
        c=0;
    }
    
    public boolean consec(int num) {
        if(num==value) c++;
        else c=0;
        return c>=k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */
