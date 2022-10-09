class LUPrefix {

    boolean vis[];
    int ans;
    public LUPrefix(int n) {
        ans=1;
        vis=new boolean[n+1];
    }
    
    public void upload(int video) {
        vis[video]=true;
    }
    
    public int longest() {
        while(ans<vis.length && vis[ans]) ans++;
        return ans-1;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */
