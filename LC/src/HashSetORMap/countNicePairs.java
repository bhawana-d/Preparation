/** https://leetcode.com/problems/count-nice-pairs-in-an-array/

hm regrouping krenge -- i waala ek side j waala ek side it will make solution super easy

TC = O(n)* log(num) --log waala for reverse (mostly we can ingnore its for digit traversal)
SC = O(n)
**/

class Solution {

    public int rev(int num){
        int rev = 0;

        while(num > 0){
            int rem = num % 10;
            rev = rev * 10 + rem;

            num /= 10;
        }

        return rev;
    }
    final int M = 1000000007;
    public int countNicePairs(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i =0;i < n ;i++){
            nums[i] = nums[i] - rev(nums[i]); // rev -> log(nums) with base 10 for integer its propotional to this
        }

        int result = 0;

        for(int i = 0;i < n;i++){
            result = (int)(result + map.getOrDefault(nums[i],0)) % M;
            map.put(nums[i],map.getOrDefault(nums[i], 0) + 1);
        }

        return result;
        
    }
}
