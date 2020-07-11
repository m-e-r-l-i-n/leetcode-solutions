class Solution {
    public String reformatDate(String date) {
        String s[]=date.split(" ");
        HashMap<String,String> hm=new HashMap<>();
        hm.put("Jan","01"); hm.put("Feb","02"); hm.put("Mar","03");hm.put("Apr","04");hm.put("May","05");hm.put("Jun","06");
        hm.put("Jul","07");hm.put("Aug","08");hm.put("Sep","09");hm.put("Oct","10");hm.put("Nov","11");hm.put("Dec","12");
        int y=Integer.parseInt(s[2]),d=0,i;
        for(i=0;i<s[0].length();i++)
        {
            char ch=s[0].charAt(i);
            if(ch>='0' && ch<='9') d=(10*d)+(ch-'0');
        }
        String da=""+d;
        if(da.length()<2) da="0"+da;
        String ans=""+y+'-'+hm.get(s[1])+'-'+da;
        return ans;
    }
}
