import java.util.*;
public class ContinuousSubarraySum {
    //LC 523
    class Solution {
        // logic
        // agar same mod ata hai then check last time kaha pr aya tha
        // and tab tak sum kitni thi
        // agar currsum-lastsum%k==0 and and kam se kam wo subarray ki size 2 se jyada then true
        // i=0 ke alwa if we have remainder as 0 matalb that is also possible
        // subaary so direct return true
        // rem jab unique ho then only add to hashmap to have greater size of that subarray
        // last me return false if not found
        // #CONTRA
        public boolean checkSubarraySum(int[] nums, int k) {
            HashMap<Integer,Pair>hm=new HashMap<>();
            int sum=0;
            for(int i=0;i<nums.length;i++){
                sum+=nums[i];
                int rem=sum%k;
                if(rem==0&&i>0){
                    return true;
                }
                if(hm.containsKey(rem)){
                    int pSum=hm.get(rem).prevsum;
                    int idx=hm.get(rem).idx;
                    if((sum-pSum)%k==0&&i-idx>1){
                        System.out.println("fdgfidguf");
                        return true;
                    }

                }else{
                    hm.put(rem,new Pair(sum,i));
                }

            }
            return false;
        }
        static class Pair{
            int prevsum;
            int idx;
            public Pair(int prev,int i){
                this.prevsum=prev;
                this.idx=i;
            }
        }
    }
}
