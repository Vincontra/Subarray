import java.util.*;
public class SubarraySumEqualsK560 {
     static class Solution {

         //logic:
         // for current index how many such subarrays may exist which has sum==k
         // for that matter we need hashmap
         // can be done in O(N^3 traversal+sum) and O(N^2 using traversal+prefix sum)
         //DONE!!!!!!!
        public int subarraySum(int[] nums, int k) {
            HashMap<Integer,Integer>hm=new HashMap<>();
            int ans=0;
            hm.put(0,1);
            int sum=0;
            for(int i=0;i<nums.length;i++){
                sum+=nums[i];
                if(hm.containsKey(sum-k)){
                    ans+=hm.get(sum-k);
                }
                hm.put(sum,hm.getOrDefault(sum,0)+1);
            }
            return ans;
        }
    }
}
