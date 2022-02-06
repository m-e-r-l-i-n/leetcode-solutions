//Tamonash Chakraborty
//O(1) for all functions except toString
//O(n) for toString
//no built-in libraries

class Bitset {
    int n,bits[],flips[],c[],f;
    public Bitset(int size) {
        n=size; f=0;
        bits=new int[n];
        flips=new int[n];
        c=new int[2];
        c[0]=n;
    }
    
    int which(int i)    //what is the value in this bit
    {
        int rem=f-flips[i]; //how many flips have been made after the last fixing
        if(rem%2==0) return bits[i];
        return bits[i]^1;
    }
    
    public void fix(int idx) {
        if(which(idx)==0)
        {
            c[0]--;
            c[1]++;
            flips[idx]=f;
            bits[idx]=1;
        }
    }
    
    public void unfix(int idx) {
        if(which(idx)==1)
        {
            c[1]--;
            c[0]++;
            flips[idx]=f; //we should not count the number of flips in this case
            bits[idx]=0;
        }
    }
    
    public void flip() {
        f++;    //increase number of flips
        c[0]=c[0]^c[1]^(c[1]=c[0]);
    }
    
    public boolean all() {
        return c[1]==n;
    }
    
    public boolean one() {
        return c[1]>0;
    }
    
    public int count() {
        return c[1];
    }
    
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++) sb.append(which(i));
        return sb.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(i);
 * obj.unfix(i);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */
