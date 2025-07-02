/**

  Leetcode Link               : https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/
    Leetcode Link               : https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/

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
//APPROACH 2 -- this will solve both the question 3016 that is part II -- simplified and clean code
//T.C : O(n) + O(26log26)
//S.C : O(1)
public int minimumPushes(String word) {
        Integer[] mp = new Integer[26];
        for(int i =0;i < 26;i++){
            mp[i] = 0;
        }
        for(char ch : word.toCharArray()){
            mp[ch - 'a']++;

        }

        Arrays.sort(mp , Collections.reverseOrder());

        int ans =0;

        for(int i = 0;i < 26;i++){
            int freq = mp[i];
            int press = (i/8 + 1);

            ans += freq * press;
        }

        return ans;
