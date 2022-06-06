//Tamonash Chakraborty
//~O(1) for logLatency, logError, and getPercentileLatency 
//O(n) for getTopErrors
class MonitoringSystem {

    HashMap<String,HashMap<String,PriorityQueue<Integer>>> laten;
    HashMap<String,PriorityQueue<Integer>> latenAll;
    HashMap<String,HashMap<String,HashMap<Integer,Integer>>> error;
    
    public MonitoringSystem() {
        laten=new HashMap<>();  //stores application-api latency values
        latenAll=new HashMap<>();   //stores latency values for applications only
        error=new HashMap<>();  //stores error logs
    }
    
    public void logLatency(String applicationName, String api, int latencyInMills) {
        if(laten.get(applicationName)==null) 
        {
            laten.put(applicationName,new HashMap<>());
            latenAll.put(applicationName,new PriorityQueue<>(Collections.reverseOrder()));
        }
        if(laten.get(applicationName).get(api)==null) laten.get(applicationName).put(api,new PriorityQueue<>(Collections.reverseOrder()));
        laten.get(applicationName).get(api).add(latencyInMills);    //add to pqueue 1
        latenAll.get(applicationName).add(latencyInMills);  //add to pqueue 2
    }
    
    public void logError(String applicationName, String api, int errorCode) {
        if(error.get(applicationName)==null) error.put(applicationName,new HashMap<>());
        if(error.get(applicationName).get(api)==null) error.get(applicationName).put(api,new HashMap<>());
        //add the errors
        error.get(applicationName).get(api).put(errorCode,error.get(applicationName).get(api).getOrDefault(errorCode,0)+1);
    }
    
    public int getPercentileLatency(int percentile, String applicationName, String api) {
        PriorityQueue<Integer> pq;
        //2 cases, 1 where application api pair exists, other they don't exist 
        if(laten.get(applicationName).get(api)!=null) pq=laten.get(applicationName).get(api);
        else pq=latenAll.get(applicationName);
        
        Stack<Integer> use=new Stack<>();
        int index=Math.max(0,pq.size()*percentile/100 -1);
        index=pq.size()-index;
        while(use.size()<index) use.add(pq.poll());
            
        int ans=use.peek();
        while(!use.isEmpty()) pq.add(use.pop());
        return ans;
    }
    
    public int[] getTopErrors(String applicationName, String api) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int o1[],int o2[])
            {
                if(o1[1]>o2[1]) return 1;
                else if(o1[1]==o2[1]) return o1[0]<o2[0]?1:-1;
                else return -1;
            }});
        //for cases where answer exists for combination
        if(error.get(applicationName).get(api)!=null && error.get(applicationName).get(api).size()>2)
        {
            for(int x:error.get(applicationName).get(api).keySet())
            {
                pq.add(new int[]{x,error.get(applicationName).get(api).get(x)});
                if(pq.size()>3) pq.poll();
            }    
        }
        else	//answer does not exist here
        {
            for(String x:error.get(applicationName).keySet())
            for(int y:error.get(applicationName).get(x).keySet())
            {
                pq.add(new int[]{y,error.get(applicationName).get(x).get(y)});
                if(pq.size()>3) pq.poll();
            }
        }
        
        int ans[]=new int[3];
        ans[2]=pq.poll()[0]; ans[1]=pq.poll()[0]; ans[0]=pq.poll()[0];
        return ans;
    }
}

/**
 * Your MonitoringSystem object will be instantiated and called as such:
 * MonitoringSystem obj = new MonitoringSystem();
 * obj.logLatency(applicationName,api,latencyInMills);
 * obj.logError(applicationName,api,errorCode);
 * int param_3 = obj.getPercentileLatency(percentile,applicationName,api);
 * int[] param_4 = obj.getTopErrors(applicationName,api);
 */
