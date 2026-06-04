import java.util.*;
public class SubarraySumEqualsK560 {
     static class Solution {

         //logic:
         // for current index how many such subarrays may exist which has sum==k
         // for that matter we need hashmap
         // can be done in O(N^3 traversal+sum) and O(N^2 using traversal+prefix sum)
//          x+k==sum
//          x=sum-k
//          if x exist that means x ke aage wale index se curr index tak sum is == k
//             hence we check that sum-k in hashmap
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

//import java.util.*;
//class Codechef {
//    static final long MOD = 998244353L;
//    static long pow(long a, long b) {
//        long res = 1;
//        while (b > 0) {
//            if ((b & 1) == 1){
//                res=res*a%MOD;
//            }
//            a=a*a%MOD;
//            b>>=1;
//        }
//        return res;
//    }
//    public static void main(String[] args) {
//        Scanner v=new Scanner(System.in);
//        int t=v.nextInt();
//        while(t-->0){
//            long N=v.nextLong();
//            int K=v.nextInt();
//            int v2 = Long.numberOfTrailingZeros(N);
//            long g = 1L << Math.min(v2, K);
//            if ((N / g) % 3 != 0) {
//                System.out.println(1);
//            }
//            else{
//                System.out.println(pow(2, 2L * K * g));
//            }
//        }
//    }
//}
