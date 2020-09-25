class Solution {
    public String largestNumber(int[] nums) {
        int i,n=nums.length;
        if(n==0) return "";
        String s[]=new String[n];
        for(i=0;i<n;i++)
        s[i]=Integer.toString(nums[i]);
        
        Arrays.sort(s,new Comparator<String>(){
            public int compare(String s1,String s2)
            {
                String sa=s1+s2,sb=s2+s1;
                return sb.compareTo(sa);
            }});
        if(s[0].equals("0")) return s[0];
        StringBuilder sb=new StringBuilder();
        for(String a:s)
        sb.append(a);
        return sb.toString();
    }
}
