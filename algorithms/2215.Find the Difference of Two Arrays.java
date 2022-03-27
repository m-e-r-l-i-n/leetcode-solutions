//Tamonash Chakraborty
//O(n)
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> diff1=differentiate(nums1,nums2);
        List<Integer> diff2=differentiate(nums2,nums1);
        List<List<Integer>> answer=new ArrayList<>();
        answer.add(diff1); answer.add(diff2);
        return answer;
    }
    
    List<Integer> differentiate(int a[],int b[])    //find the values of array a not present in array b
    {
        List<Integer> ans=new ArrayList<>();    //store all resultant integers here
        HashMap<Integer,Boolean> hm=new HashMap<>();    //map to store all distinct integers
        for(int x:a) hm.put(x,false);   //false means this value does not exist in b
        for(int x:b)
        if(hm.get(x)!=null) hm.put(x,true); //value exists in a and also in b
        
        for(int x:hm.keySet())
        if(hm.get(x)==false) ans.add(x);
        return ans;
    }
}
