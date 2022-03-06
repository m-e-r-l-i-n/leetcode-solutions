//Tamonash Chakraborty
//O(n*log(max(nums[i])))
class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Deque<Integer> dq=new ArrayDeque<>();   //use it both as a stack and list
        for(int x:nums)
        {
            int l=x;    //get lcm with previous non coprime numbers
            while(!dq.isEmpty())
            {
                int g=gcd(l,dq.peekLast());
                if(g==1) break;
                l=(int)(1l*dq.removeLast()*l/g);
            }
            dq.addLast(l);
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        while(!dq.isEmpty()) ans.add(dq.pollFirst());
        return ans;
    }
    
    int gcd(int a,int b)
    {
        int t;
        while(b!=0)
        {
            t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
}
