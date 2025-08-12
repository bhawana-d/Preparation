//https://leetcode.com/problems/reorganize-string/description/
//TC = O(n logk) -> MaxHeap; O(n) -> without that
//MAXHEAP
class Solution {
    public String reorganizeString(String s) {
        int n = s.length();

        int[] count = new int[26];

        for(char ch : s.toCharArray()){
            count[ch - 'a']++;

            if(count[ch - 'a'] > (n+1)/2){
                return "";
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0] - a[0]);

        for(char ch = 'a' ; ch <= 'z';ch++){
            if(count[ch - 'a'] > 0){
                pq.offer(new int[]{count[ch - 'a'] ,ch});
            }
           
        }

        String res = "";
        while(pq.size() >=2){
            int[] val1 = pq.poll();
            int[] val2 = pq.poll();
            
            res = res + (char)val1[1];
            val1[0]--;
            res = res + (char)val2[1];
            val2[0]--;

            if(val1[0] > 0){
                pq.offer(val1);
            }
            if(val2[0] > 0){
                pq.offer(val2);
            }
        }
        if(!pq.isEmpty()){
            int[] tmp = pq.poll();
            res = res+ (char)tmp[1];
        }
        return res;
    }
}

//
class Solution {
    public String reorganizeString(String s) {
        int n = s.length();

        int maxCount = 0;
        int i = 0;
        char maxCh = '@';
        int[] count = new int[26];
        //StringBuilder sb = new StringBuilder(s);
        StringBuffer sf = new StringBuffer(s);
        //char[] res = new char[n];
        for(char ch : s.toCharArray()){
            count[ch - 'a']++;

            if(count[ch - 'a'] > (n+1)/2){
                return "";
            }

            if(count[ch - 'a'] > maxCount){
                maxCount = count[ch - 'a'] ;
                maxCh = ch;
            }
        }
        while(maxCount > 0){
            //res[i] = maxCh;
            //sb.setCharAt(i,maxCh);
            sf.setCharAt(i,maxCh);
            i += 2;
            maxCount--;
            count[maxCh - 'a']--;
        }

        for(char c = 'a' ; c <= 'z';c++){
            while(count[c-'a'] > 0){
                if(i > n -1) i =1;
                //res[i] = c;
                 //sb.setCharAt(i,c);
                 sf.setCharAt(i,c);
                i+=2;
                count[c-'a']--;
            }
        }
        //return new String(res);
        //return sb.toString();
        return sf.toString();

       //PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0] - a[0]);
        /* PriorityQueue<Map.Entry<Integer,Character>> pq = new PriorityQueue<>((a,b)->b.getKey() - a.getKey()); */

       /*   for(char ch = 'a' ; ch <= 'z';ch++){ //26
            if(count[ch - 'a'] > 0){
                //pq.offer(new int[]{count[ch - 'a'] ,ch});
                //pq.offer(new HashMap<>(count[ch - 'a'] ,ch));
            }
           
        }  */

       /*  for(int i = 0;i < n;i++){
            if(count[i] > 0){
                pq.offer(new int[]{count[i],i + 'a'});
            }
        } */
/* 
        String res = "";
        while(pq.size() >=2){ //26
            int[] val1 = pq.poll();
            int[] val2 = pq.poll();
            
            res = res + (char)val1[1];
            val1[0]--;
            res = res + (char)val2[1];
            val2[0]--;

            if(val1[0] > 0){
                pq.offer(val1);
            }
            if(val2[0] > 0){
                pq.offer(val2);
            }
        }
        if(!pq.isEmpty()){
            int[] tmp = pq.poll();
            res = res+ (char)tmp[1];
        }
        return res; */
    }
    //max O(n) -> O(nlogk)
}
