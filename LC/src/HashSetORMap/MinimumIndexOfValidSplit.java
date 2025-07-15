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
//APPROACH ---2
class Solution {
    public int minimumIndex(List<Integer> nums) {

        int n = nums.size();

        int maj = -1;
        int count = 0;

        for(int num : nums){
            if(count == 0){
                maj = num;
                count = 1;;
            }else if(num == maj){
                count++;
            }else{
                count--;
            }
        }
        
        int majCount = 0;

        for(int num : nums){
           if(num == maj){
            majCount++;
           }
        }

        count = 0;
        for(int i = 0;i < n ;i++){
            int num = nums.get(i);
            
            if(num == maj){
                count++;
            }
            int remainCount = majCount - count;

            int n1 = i+1;
            int n2 = n - i -1;

            if(2*count> n1 && 2*remainCount > n2){
                return i;
            }
        }
        return -1;
    }
}
