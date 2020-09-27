class ThroneInheritance {

    LinkedHashMap<String,ArrayList<String>> hm=new LinkedHashMap<>();
    HashMap<String,Boolean> pr=new HashMap<>();
    int mem=0; String k="";
    public ThroneInheritance(String kingName) {
        hm.put(kingName,new ArrayList<>());
        pr.put(kingName,true);
        mem++;
        k=kingName;
    }
    
    public void birth(String parentName, String childName) {
        hm.get(parentName).add(childName);
        pr.put(childName,true);
        hm.put(childName,new ArrayList<>());
        mem++;
    }
    
    public void death(String name) {
        pr.put(name,false);
        mem--;
    }
    
    public List<String> getInheritanceOrder() {
        List<String> l=new ArrayList<>();
        Stack<String> q=new Stack<>();
        q.add(k); 
        while(!q.isEmpty())
        {
            String s=q.pop();
            if(pr.get(s)) l.add(s);
            for(int i=hm.get(s).size()-1;i>=0;i--)
            q.add(hm.get(s).get(i));    
        }
        return l;
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
