/**  

https://leetcode.com/problems/binary-trees-with-factors/description/


intuition ::
---
sort - > nlogn
map me store -- n
i = 1, i<n 
j =0;j<i
  Total n^2
Multiply -- root = arr[i] , LC = arr[j] , root%LC == 0 , rc = root/LC -> map
mp[root] += mp[LC] * mp[RC] 


**/

class BinaryTreeWithFactors {
    private static final int MOD = 1000000007;
    public int numFactoredBinaryTrees(int[] arr) {
        //int n = arr.length;
        Arrays.sort(arr);
        HashMap <Integer,Long> map = new HashMap<>();
        map.put(arr[0],1L);
        for(int i = 1;i < arr.length;i++){
            long count = 1;
            int root = arr[i];
            for(int j = 0; j < i;j++){
                int v = arr[j];
               
                if((root % v == 0) && (map.containsKey(root/v))){
                    count += (map.get(root / v) * map.get(v)) % MOD;
                    count %= MOD;
                }
            }
            map.put(arr[i], count);
        }

        int result = 0;

        for(int i =0;i < arr.length;i++){
            result = (int)(result + map.get(arr[i])) % MOD;
        }
        return result;
    }
}
