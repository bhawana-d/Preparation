//https://leetcode.com/problems/replace-words/description/
//T.C : o(n*l + m*l^2) , n = number of words in the dictionary, m be the number of words in the sentence, and l be the average length of each word.
//S.C : O(n*l)
class Solution {
    private String findRoot(String word , HashSet<String> set){
        for(int l =0;l < word.length();l++){
            String root = word.substring(0,l);
            if(set.contains(root)){
                return root;
            }
        }
        return word;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> set = new HashSet<>(dictionary);

        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");

        for(String word : words){
            result.append(findRoot(word , set)).append(" ");
        }

        return result.toString().trim();
    }
}
