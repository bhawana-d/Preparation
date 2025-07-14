https://leetcode.com/problems/minimum-index-of-a-valid-split/
class Solution {
    public int minimumIndex(List<Integer> nums) {
        HashMap<Integer,Integer> mp1 = new HashMap<>();
        HashMap<Integer,Integer> mp2 = new HashMap<>();

        int n = nums.size();
        
        for(int num : nums){
            mp2.put(num, mp2.getOrDefault(num , 0) + 1);
        }

        for(int i = 0;i < n ;i++){
            int num = nums.get(i);

            mp1.put(num , mp1.getOrDefault(num , 0) + 1);
            mp2.put(num , mp2.getOrDefault(num , 0) - 1);

            int n1 = i+1;
            int n2 = n - i -1;

            if(mp1.get(num)> n1/2 && mp2.get(num) > n2/2){
                return i;
            }
        }
        return -1;
    }
}
