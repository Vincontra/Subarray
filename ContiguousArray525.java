import java.util.*;
public class ContiguousArray525 {
    //class Solution {
        public int findMaxLength(int[] nums) {
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    nums[i]=-1;
                }
            }
            int pfx[]=new int[nums.length];
            pfx[0]=nums[0];
            for(int i=1;i<nums.length;i++){
                pfx[i]=pfx[i-1]+nums[i];
            }

            HashMap<Integer,Integer>hm=new HashMap<>();
            int ans=0;
            for(int i=0;i<pfx.length;i++){
                if(hm.containsKey(pfx[i])){
                    ans=Math.max(ans,i-hm.get(pfx[i]));

                }else{
                    hm.put(pfx[i],i);
                }
            }
            //last se 0 kaha pr hai wo+1
            // if in case we might have not find any repeating key in that case
            // we need to find the last index where it is 0
            // that is the biggest subarray
            for(int i=pfx.length-1;i>=0;i--){
                if(pfx[i]==0){
                    ans=Math.max(ans,i+1);
                }
            }
            return ans;
        }
    //}
}
