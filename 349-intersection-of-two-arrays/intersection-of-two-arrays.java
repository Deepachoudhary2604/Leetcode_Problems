import java.util.HashSet;
import java.util.ArrayList;
class Solution {
    public int[] intersection(int[] nums1,int[] nums2) {

       HashSet<Integer> set1=new HashSet<>();
        HashSet<Integer> set3=new HashSet<>();
       for(int num:nums1){
        set1.add(num);
        set3.add(num);
       }
       HashSet<Integer> set2=new HashSet<>();
       for(int num:nums2){
        set2.add(num);
        set3.add(num);
       }
       ArrayList<Integer> ans=new ArrayList<>();
       for(int i:set3){
        if(set1.contains(i) && set2.contains(i)){
            ans.add(i);
        }
       }
       int[] temp=new int[ans.size()];
       for(int i=0;i<ans.size();i++){
        temp[i]=ans.get(i);
       }
       return temp;
    }
}