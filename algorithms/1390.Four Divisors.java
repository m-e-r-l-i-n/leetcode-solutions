class Solution {
    public int sumFourDivisors(int[] nums) {
        boolean sieve[]=new boolean[100001];
        int i,j;
        ArrayList<Integer> pr=new ArrayList<>();
        for(i=2;i<=100000;i++)
        if(sieve[i]==false)
        {
            pr.add(i);
            for(j=2*i;j<=100000;j+=i)
            sieve[j]=true;
        }
        boolean c[]=new boolean[1000001]; int f[]=new int[1000001];
        for(i=0;i<pr.size();i++)
        {
            int x=pr.get(i);
            long l=x*x*x;
            if(l<=1000000) {c[(int)l]=true; f[(int)l]=x;}
            for(j=i+1;j<pr.size();j++)
            {
                int y=pr.get(j);
                l=x*y;
                if(l>1000000) break;
                c[(int)l]=true;
                f[(int)l]=x;
            }
            if(j==i+1) break;
        }
        
        int sum=0;
        for(i=0;i<nums.length;i++)
        if(c[nums[i]])
        //{System.out.println(nums[i]);
        sum+=1+nums[i]+f[nums[i]]+nums[i]/f[nums[i]];//}
        
        return sum;
    }
}
