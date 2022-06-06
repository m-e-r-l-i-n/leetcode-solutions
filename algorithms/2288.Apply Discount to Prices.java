//Tamonash Chakraborty
//O(n)
class Solution {
    public String discountPrices(String sentence, int discount) {
        String words[]=sentence.split(" ");
        StringBuilder res=new StringBuilder();
        for(int i=0;i<words.length;i++)
        {
            if(price(words[i])) res.append(discount(words[i],discount));
            else res.append(words[i]);
            if(i!=words.length-1) res.append(" ");
        }
        return res.toString();
    }
    
    boolean price(String s) //check if s is a price
    {
        if(s.charAt(0)!='$') return false;
        
        int n=s.length();
        if(n==1) return false;
        for(int i=1;i<n;i++)
        if(s.charAt(i)>='0' && s.charAt(i)<='9') continue;
        else return false;
        return true;
    }
    
    String discount(String s,int d) //apply a discount of d on s
    {
        d=100-d;
        if(d==100) return s+".00";	//no change necessary
        s=s.substring(1);	//remove the dollar first
        int n=s.length(),product[]=new int[n+5],i;
        //multiply string with (100-d) to get final price*100.
        for(i=0;i<2;i++)
        {
            int j,use=d%10;
            if(i==1) use=d/10; 
            
            for(j=0;j<n;j++)
            product[i+j]+=use*(s.charAt(n-1-j)-'0');	//compute products in reverse
        }
        
        int carry=0;
        StringBuilder sb=new StringBuilder();
        Deque<Integer> deque=new LinkedList<>();	//to add values in reverse
        for(i=0;i<=n;i++)
        {
            carry+=product[i];
            product[i]=carry%10;
            carry/=10;
            deque.addLast(product[i]);
        }    
        while(carry>0)  //append carry until it is zero 
        {
            product[i]=carry%10;
            carry/=10;
            deque.addLast(product[i++]);
        }
        while(!deque.isEmpty() && deque.peekLast()==0) deque.pollLast();
        while(deque.size()<3) deque.addLast(0);	//we need at least 3 values -> 0.00
        while(!deque.isEmpty()) sb.append(deque.pollLast());
        
        String ans=sb.toString();
        //add the .
        ans="$"+ans.substring(0,ans.length()-2)+"."+ans.substring(ans.length()-2);
        return ans;
    }
}
