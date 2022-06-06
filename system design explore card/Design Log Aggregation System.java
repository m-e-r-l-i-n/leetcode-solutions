//Tamonash Chakraborty
//O(1) for push
//O(n) for getLogsFromMachine, getLogsOfService (please note that the lists need to be printed, taking complexity to O(n))
//O(sum(words)*len(stringSearch)) for search
//~O(n^2)
class LogAggregator {

    HashMap<Integer,String> logs;
    List<Integer> mac[],ser[];
    
    public LogAggregator(int machines, int services) {
        mac=new List[machines];
        ser=new List[services];
        int i;
        for(i=0;i<Math.max(machines,services);i++)
        {
            if(i<machines) mac[i]=new ArrayList<>();
            if(i<services) ser[i]=new ArrayList<>();
        }
        
        logs=new HashMap<>();
    }
    
    public void pushLog(int logId, int machineId, int serviceId, String message) {
        logs.put(logId,message);
        mac[machineId].add(logId);  //the latest log for machine
        ser[serviceId].add(logId);  //the latest log for server
    }
    
    public List<Integer> getLogsFromMachine(int machineId) {
        return mac[machineId];
    }
    
    public List<Integer> getLogsOfService(int serviceId) {
        return ser[serviceId];
    }
    
    public List<String> search(int serviceId, String stringSearch) {
        List<String> ans=new ArrayList<>();
        for(int x:ser[serviceId])
        if(present(logs.get(x),stringSearch)) ans.add(logs.get(x));
        return ans;
    }
    
    boolean present(String a,String b)
    {
        int n=a.length(),m=b.length(),i,j;
        for(i=0;i+m<=n;i++)
        {
            for(j=0;j<m;j++)
            if(a.charAt(i+j)!=b.charAt(j)) break;
            if(j==m) return true;
        }    
        return false;
    }
}

/**
 * Your LogAggregator object will be instantiated and called as such:
 * LogAggregator obj = new LogAggregator(machines, services);
 * obj.pushLog(logId,machineId,serviceId,message);
 * List<Integer> param_2 = obj.getLogsFromMachine(machineId);
 * List<Integer> param_3 = obj.getLogsOfService(serviceId);
 * List<String> param_4 = obj.search(serviceId,stringSearch);
 */
