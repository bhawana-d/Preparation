//https://leetcode.com/problems/rabbits-in-forest/description/
class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans =0;
        int n = answers.length;
        for(int i = 0;i < n;i++){
            map.put(answers[i] , map.getOrDefault(answers[i]  , 0) + 1);
        }
        for(int i : map.keySet()){
            int grpSize = i + 1;
            int grp = (i + map.get(i)) / grpSize;

            ans += grp * grpSize;
        }
        return ans;
    }
}
//----------
    class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans =0;
        int n = answers.length;
        for(int i = 0;i < n;i++){
            map.put(answers[i] , map.getOrDefault(answers[i]  , 0) + 1);
        }
        for(int i : map.keySet()){
            int grpSize = i + 1;
            int grp = (int)Math.ceil((double)map.get(i) / grpSize);

            ans += grp * grpSize;
        }
        return ans;
    }
}
