//APPROACH -- 1 : O(n3)
//https://leetcode.com/problems/equal-row-and-column-pairs/description/
class EqualPairs {
    public int equalPairs(int[][] grid) {
        int count = 0;
        int n = grid.length;
        for(int r = 0; r < n ; r++){
            for(int c = 0 ; c < n;c++){
                boolean isEqual = true;
                for(int i = 0; i< n;i++){
                    if(grid[r][i] != grid[i][c]){
                        isEqual = false;
                        break;
                    }

                    
                }
                if(isEqual == true){
                    count++;
                }
            }
        }
        return count;
    }
}
///APPROACH - 2 0(n2) * 0[nlogn)
class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0;
        HashMap<List<Integer> , Integer> map = new HashMap<>();
        int n = grid.length;

        for(int i = 0 ; i < n ;i++){
            ArrayList <Integer> rowList = new ArrayList<>();
            for(int j = 0 ;j < n;j++){
                rowList.add(grid[i][j]);
            }
            map.put(rowList,map.getOrDefault(rowList,0) + 1);
        }

        for(int c = 0; c < n;c++){
            ArrayList<Integer> colList = new ArrayList<>();
            for(int r =0 ;r < n;r++){
                colList.add(grid[r][c]);
            }

            count += map.getOrDefault(colList,0);
        }

        return count;

    }
}
