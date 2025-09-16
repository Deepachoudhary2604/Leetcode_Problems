import java.util.HashSet;
import java.util.ArrayList;
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       HashSet<Integer> set1=new HashSet<>();
       for(int i=0;i<nums1.length;i++){
        set1.add(nums1[i]);
       }
       HashSet<Integer> set2=new HashSet<>();
       for(int i=0;i<nums2.length;i++){
        set2.add(nums2[i]);
       }
       ArrayList<Integer> l1=new ArrayList<>();
       for(int v:set1){
        if(set2.contains(v)){
            l1.add(v);
        }
       }
       int[] ans=new int[l1.size()];
       for(int i=0;i<ans.length;i++){
        ans[i]=l1.get(i);
       }
       return ans;
    }
}