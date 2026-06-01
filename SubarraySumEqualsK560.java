import java.util.*;
public class SubarraySumEqualsK560 {
     static class Solution {
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
