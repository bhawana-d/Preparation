//https://leetcode.com/problems/total-characters-in-string-after-transformations-i/description/
class Solution {
    public int lengthAfterTransformations(String s, int t) {
        final int M = 1_000_000_007;
        
        int[] map = new int[26];

        for(char ch : s.toCharArray()){
            map[ch - 'a']++;
        }

        while(t-- > 0){
            int[] tmp = new int[26];
            for(int i =0;i < 26;i++){
                char ch = (char)(i + 'a');
                int freq = map[i];

                if(ch != 'z'){
                    tmp[ch + 1 - 'a'] = (tmp[ch + 1 - 'a'] + freq)%M;

                }else{
                    tmp['a' - 'a'] = (tmp['a' - 'a'] + freq)%M;
                    tmp['b' - 'a'] = (tmp['b'- 'a'] + freq)%M;
                }
            }
            map = tmp;
        }
        int ans = 0;
        for(int count : map){
            ans = (ans + count)%M;
        }

        return ans;
    }
}
