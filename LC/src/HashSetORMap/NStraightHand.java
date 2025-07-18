/**
https://leetcode.com/problems/hand-of-straights/
/Approach (Simply using map)
//T.C  : O(nlogn) + O(n*groupSize)
//S.C  : O(n)
**/
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0){
            return false;
        }
        
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int card : hand){
            map.put(card,map.getOrDefault(card,0) + 1);
        }

        while(!map.isEmpty()){
            int curr = map.firstKey();

            for(int i =0;i < groupSize;i++){
                if(!map.containsKey(curr + i)){
                    return false;
                }

                map.put(curr + i , map.get(curr+i) - 1);
                if(map.get(curr + i) == 0){
                    map.remove(curr + i);
                }


            }
        }

        return true;

    }
}
