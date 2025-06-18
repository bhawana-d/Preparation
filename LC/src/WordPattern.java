//LC - https://leetcode.com/problems/word-pattern/description/
// for both approach TC and SC : O(n)
//Approach 1 -----------------

class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<String, Character> map = new HashMap<>();
        HashSet<Character> usedCharSet = new HashSet<>();

        String[] words = s.split(" ");

        if(words.length != pattern.length()){
            return false;
        }

        for(int i = 0;i < pattern.length();i++){
            String word = words[i];
            char ch = pattern.charAt(i);
        
            if(!map.containsKey(word) && ! usedCharSet.contains(ch)){
                map.put(word,ch);
                usedCharSet.add(ch);
            }
            else if(!map.containsKey(word) || map.get(word) != ch){
                return false;
            }
            /*
             else if(map.getOrDefault(word,'\0') != ch){
                return false;
            } -- we can use else if condition like this*/ 
                
        }
        return true;
    }
}


// APPROACH --- 2 ------------------------------------------------
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<String, Integer> wordToIndex = new HashMap<>();
        HashMap<Character, Integer> charToIndex = new HashMap<>();

        String[] words = s.split(" ");

        if(words.length != pattern.length()){
            return false;
        }

        for(int i = 0;i < pattern.length();i++){
            String word = words[i];
            char ch = pattern.charAt(i);
        
            if(!charToIndex.getOrDefault(ch,0).equals(wordToIndex.getOrDefault(word,0))){
                return false;
            }

            wordToIndex.put(word,i+ 1);
            charToIndex.put(ch,i + 1); /*using i + 1 as 
                                        If the key does not exist, it returns 0 (the default value).
                                    If you use i instead of i + 1, then for the first index (i = 0), the value will be 0.
                                        Now, there's no way to distinguish between:
                                    a key that was never seen (returns 0 by default)
                                        and a key that was seen at index 0 (also stores 0)*/
            
/*
          ---use this instead 
          if(!charToIndex.getOrDefault(ch,-1).equals(wordToIndex.getOrDefault(word,-1))){
                return false;
            }
            wordToIndex.put(word,i);
            charToIndex.put(ch,i);
            
            */
                
        }
        return true;
    }
}
