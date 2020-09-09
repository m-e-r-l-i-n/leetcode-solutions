class Solution {
    public int compareVersion(String version1, String version2) {
        String v1[]=version1.split("\\.");
        String v2[]=version2.split("\\.");
        int i,l=Math.max(v1.length,v2.length);
        for(i=0;i<l;i++)
        {
            int x=i<v1.length?Integer.parseInt(v1[i]):0;
            int y=i<v2.length?Integer.parseInt(v2[i]):0;
            if(x>y) return 1;
            else if(x<y) return -1;
        }
        return 0;
    }
}
