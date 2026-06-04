import java.util.*;
public class SubarraySumsDivisiblebyK974 {
        public int subarraysDivByK(int[] nums, int k) {
            int sum=0;
            HashMap<Integer,Integer>hm=new HashMap<>();
            int ans=0;
            hm.put(0,1);
            for(int i=0;i<nums.length;i++){
                sum+=nums[i];
                int rem=(sum%k+k)%k; // this is imp as what if rem is neg then we want rem in range of
                // 0 to k-1 only to normalize that we will do that
                if(hm.containsKey(rem)){
                    ans+=hm.get(rem);
                }
                hm.put(rem,hm.getOrDefault(rem,0)+1);
            }
            return ans;
        }
}





// If two prefix sums have the same remainder when divided by k,
// then their difference is divisible by k.
// prefixSum[j] % k = prefixSum[i] % k
// Then:
// (prefixS[j]-prefixS[i])%k=0
// Meaning the subarray (i+1 ... j) has a sum divisible by k.
// Example:
// k = 5
// prefixSum = 12 -> rem = 2
// prefixSum = 17 -> rem = 2
//
// Since both remainders are same:
// 17 - 12 = 5, which is divisible by 5.

// logic yahi hai sum maintain rakho
// usko with %k karo if presents to kine baar add that to ans
// uska meaning current index pr jo hai ani fisrt time kaha pr hai waha se just agge se current index tak ki sum%k==0 hi hoga

// Why hm.put(0,1)? ye karna padega in case jaha pr 0 as mod apprread shayad pehli baar ho uske liye
// It represents the empty prefix sum before the array starts.
// This helps count subarrays whose prefix sum itself is divisible by k.


// Handling negative no:  [0 to k-1] hi remainder track krne hai otherwise that will be always unique ans hokar bhi ans nhi milega as hashmap me khi hit hi nhi hoga duplicate

// Java me kya scene hai!!
// -1 % 5 = -1
// But mathematically:
// -1 ≡ 4 (mod 5)
// So normalize the remainder:
// int rem = sum % k;
// if(rem < 0) rem += k;
// or we can also write it as  int rem = ((sum % k) + k) % k;
// This ensures all remainders lie in [0, k-1]



