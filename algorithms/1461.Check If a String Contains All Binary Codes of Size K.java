class Solution {
    public boolean hasAllCodes(String s, int k) {
        int i,j,size=(int)Math.pow(2,k);
        char c[]=s.toCharArray();
        HashMap<String,Integer> hm=new HashMap<>();
        for(i=0;i<=s.length()-k;i++)
        {
            String st=""; int t=0;
            for(j=i;t<k;j++,t++)
            st+=c[j];
            if(hm.get(st)==null) hm.put(st,1);
            if(hm.size()==size) return true;    
        }   
        return false;
    }
}
