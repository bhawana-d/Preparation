/** 
https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/
TC = O(n)
SC = O(n)
**/
class Solution {
    HashMap<Integer, List<Integer>> adj = new HashMap<>();
    public int[] restoreArray(int[][] adjacentPairs) {

       
        for(int[] edges : adjacentPairs){
            int x = edges[0];
            int y = edges[1];

            adj.computeIfAbsent(x,k -> new ArrayList()).add(y);
            adj.computeIfAbsent(y,k -> new ArrayList()).add(x);
        }

        int root = 0;
        for(int num :adj.keySet()){
            if(adj.get(num).size() == 1){
                root = num;
                break;
            }
        }
        int[] result = new int[adj.size()];
        dfs(root,Integer.MAX_VALUE,result,0);

        return result;
    }

    public void dfs(int node,int prev,int[] res,int i){
        res[i] = node;
        for(int neigh : adj.get(node)){
            if(neigh != prev){
                dfs(neigh , node , res,i+1);
            }
        }
    }
}
