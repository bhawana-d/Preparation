/**
//Approach-1 (Using Map and doing as asked in Problem)
//T.C : O(n) + O(26log26)
//S.C : O(n)
**/
class Solution {
    public int minimumPushes(String word) {
        if(word.length() <= 8){
            return word.length();
        }

        int count = 0;
        Map<Integer,Integer> map =new HashMap<>();
        int assignKey = 2;

        for(char ch : word.toCharArray()){
            if(assignKey > 9){
                assignKey = 2;
            }

            map.put(assignKey,map.getOrDefault(assignKey,0) + 1);
            count += map.get(assignKey);
            assignKey++;
        }
        return count;
    }
}
