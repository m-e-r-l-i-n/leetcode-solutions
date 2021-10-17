//Tamonash Chakraborty
//O(1) per query 
class Bank {
	int n;
    long cur[];
    public Bank(long[] balance) {
        n=balance.length;
        cur=new long[n];
        for(int i=0;i<n;i++) cur[i]=balance[i];
    }
    
    boolean okay(int i)
    {
        return i>0 && i<=n;
    }
    
    public boolean transfer(int i, int j, long money) {
        if(!okay(i) || !okay(j)) return false;
        i--; j--;
        if(cur[i]<money) return false;
        cur[i]-=money;
        cur[j]+=money;
        return true;
    }
    
    public boolean deposit(int i, long money) {
        if(!okay(i)) return false;
        cur[--i]+=money;
        return true;
    }
    
    public boolean withdraw(int i, long money) {
        if(!okay(i--)) return false;
        if(cur[i]<money) return false;
        cur[i]-=money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(i,j,money);
 * boolean param_2 = obj.deposit(i,money);
 * boolean param_3 = obj.withdraw(i,money);
 */
