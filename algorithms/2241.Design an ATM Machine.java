//Tamonash Chakraborty
//O(1) for deposit and withdraw
class ATM {
    long notes[];
    int val[];
    public ATM() {
        notes=new long[5];
        val=new int[5];
        val[0]=20; val[1]=50; val[2]=100; val[3]=200; val[4]=500;
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i=0;i<5;i++) notes[i]+=banknotesCount[i];
    }
    
    public int[] withdraw(int amount) {
        int i,ans[]=new int[5];
        for(i=4;i>=0;i--)
        {
            long min=amount/val[i];
            min=Math.min(min,notes[i]);
            ans[i]=(int)min;
            //notes[i]-=min;
            amount-=min*val[i];
        }    
        if(amount!=0) return new int[]{-1};
        else 
        {
            for(i=4;i>=0;i--) notes[i]-=ans[i];
            return ans;
        }
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */
