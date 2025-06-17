/**
https://leetcode.com/problems/unique-number-of-occurrences/description/
**/
//Approach-1 (Simple using hash map and set)
//T.C : O(n)
//S.C : O(n)

class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int digit : arr){
            map.put(digit , map.getOrDefault(digit, 0) + 1);
        }

        HashSet<Integer> set = new HashSet<>();

        for(int freq : map.values()){
            if(set.contains(freq)){
                return false;
            }
            set.add(freq);
        }
        return true;
    }
}
//Approach-2( using Constraints:1 <= arr.length <= 1000
//-1000 <= arr[i] <= 1000)
//T.C : O(nlogn)
//S.C : O(1)
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] array = new int[2001];

        for(int freq : arr){
            array[freq + 1000]++;
        }
        Arrays.sort(array);

        for(int i = 1 ; i < 2001 ; i++){
            if(array[i] != 0 && array[i] == array[i-1]){
                return false;
            }
        }
        return true;
    }
}
