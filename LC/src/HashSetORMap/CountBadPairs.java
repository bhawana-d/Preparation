//https://leetcode.com/problems/count-number-of-bad-pairs/description/
class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        long res = 0;

        for(int i =0;i < n;i++){
            nums[i] = nums[i] - i;
        }
        map.put(nums[0] , 1);

        for(int j =1;j<n;j++){
            int countOfNumberJ = map.getOrDefault(nums[j],0);
            int totalNumberBeforeJ = j;
            int noOfBadPairs = totalNumberBeforeJ - countOfNumberJ;
     
            res += noOfBadPairs;
            
            map.put(nums[j] ,countOfNumberJ + 1);
           
        }
        return res;
    }
}
///APPROACH 2
 int n = nums.length;
        long result = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int diff = nums[i] - i;
            int totalPairsTillIndex = i;
            int goodPairs = mp.getOrDefault(diff, 0);
            
            result += (totalPairsTillIndex - goodPairs);
            
            mp.put(diff, goodPairs + 1);
        }
        
        return result;
