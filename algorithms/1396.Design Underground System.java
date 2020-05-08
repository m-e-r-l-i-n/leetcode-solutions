class UndergroundSystem {

    String stn[][]=new String[20000][2];
    double avg[][]=new double[20000][2]; int t;
    HashMap<Integer,Integer> hm=new HashMap<>();
    HashMap<Integer,String> al=new HashMap<>();
    
    public UndergroundSystem() {
        for(int i=0;i<20000;i++)
        {stn[i][0]="";stn[i][1]="";}
        t=0;
    }
    
    public void checkIn(int id, String stationName, int t) {
        hm.put(id,t); al.put(id,stationName); 
    }
    
    public void checkOut(int id, String stationName, int ti) {
        double time=ti-hm.get(id); int flag=0;
        String st2=al.get(id);
        for(int i=0;i<t;i++)
            if((stn[i][0].equals(st2) && stn[i][1].equals(stationName)))
            {avg[i][0]+=time; avg[i][1]++; flag=1; break;}
        if(flag==0)
        {stn[t][0]=st2; stn[t][1]=stationName; avg[t][0]=time; avg[t][1]++; t++;}
        hm.remove(id); al.remove(id);
        
    }
    
    public double getAverageTime(String startStation, String endStation) {
        
        for(int i=0;i<t;i++)
            if((stn[i][0].equals(startStation) && stn[i][1].equals(endStation))) return avg[i][0]/avg[i][1];
        return 0;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
