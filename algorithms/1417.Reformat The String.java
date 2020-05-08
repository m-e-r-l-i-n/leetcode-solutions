class Solution {
    public String reformat(String s) {
        ArrayList<Character> a=new ArrayList<>();
        ArrayList<Character> d=new ArrayList<>();
        int i;
        for(i=0;i<s.length();i++)
            if(s.charAt(i)>=48 && s.charAt(i)<=57) d.add(s.charAt(i));
            else a.add(s.charAt(i));
        if(Math.abs(a.size()-d.size())>1) return "";
        String st="";
        if(d.size()>a.size())
        {
            for(i=0;i<a.size();i++)
            {st+=d.get(i); st+=a.get(i);}
            while(i<d.size()) st+=d.get(i++);
            return st;
        }
        else
        {
            for(i=0;i<d.size();i++)
            {st+=a.get(i); st+=d.get(i);}
            while(i<a.size()) st+=a.get(i++);
            return st;            
        }
           
    }
}
