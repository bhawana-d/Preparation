//https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/description/
//TC = O(n)
//SC = O(n)

class Solution {
    public int[] queryResults(int limit, int[][] queries) {

        int n = queries.length;
        int[] res = new int[n];
        HashMap<Integer,Integer> colorMap = new HashMap<>(); //cour ->colorCount

        HashMap<Integer,Integer> ballMap = new HashMap<>();//ball[i] == x;
     

        for(int i =0;i < n;i++){

            int ball = queries[i][0];
            int color = queries[i][1];

            if(ballMap.containsKey(ball)){ // prev coloured
                int prevColor = ballMap.get(ball);

                colorMap.put(prevColor , colorMap.get(prevColor) - 1);
                if(colorMap.get(prevColor) == 0){
                    colorMap.remove(prevColor);
                } 
            }
             colorMap.put(color, colorMap.getOrDefault(color , 0) + 1);
             ballMap.put(ball , color);
           // ballArr[ball] = color; 
             res[i] = colorMap.size();
        }

        return res;

    }
}

// withh array for color and ball it will Memory Limit Exceeded
//TC = O(n)
//SC = O(limit)
class Solution {
    public int[] queryResults(int limit, int[][] queries) {

        int n = queries.length;
        int[] res = new int[n];
        HashMap<Integer,Integer> colorMap = new HashMap<>(); //cour ->colorCount

        int[] ballArr = new int[limit + 1]; //ball[i] == x;
        Arrays.fill(ballArr,-1);

        for(int i =0;i < n;i++){

            int ball = queries[i][0];
            int color = queries[i][1];

            if(ballArr[ball] != -1){ // prev coloured
                int prevColor = ballArr[ball];

                colorMap.put(prevColor , colorMap.get(prevColor) - 1);
                if(colorMap.get(prevColor) == 0){
                    colorMap.remove(prevColor);
                } 
            }
             colorMap.put(color, colorMap.getOrDefault(color , 0) + 1);
            ballArr[ball] = color; 
             res[i] = colorMap.size();
        }

        return res;

    }
}
