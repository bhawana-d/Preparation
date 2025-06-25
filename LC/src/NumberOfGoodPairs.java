//https://leetcode.com/problems/number-of-good-pairs/description/
//Approach1- brute force
class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for(int i = 0; i< nums.length;i++){
            for(int j = i+1;j< nums.length;j++){
                if(nums[i] == nums[j] && i < j){
                    count++;
                }
            }
        }
        return count;
    }
}
// Approach 2
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int res = 0;
        Map<Integer , Integer> mp = new HashMap<>();

        for(int num : nums){
            mp.put(num , mp.getOrDefault(num, 0) + 1);
        }

       
        for(int count : mp.values()){
            res += (count * (count - 1))/2;
        }
        return res;
    }
}

// APPROACH 3

class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer , Integer> mp = new HashMap<>();
        int count = 0;
        for(int num : nums){
            if(mp.containsKey(num)){
                count += mp.get(num);
            }
            mp.put(num , mp.getOrDefault(num, 0) + 1);
        }
        return count;
    }
}
