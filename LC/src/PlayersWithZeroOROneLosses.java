//LeetCode Link -https://leetcode.com/problems/find-players-with-zero-or-one-losses
//T.C : O(n*logn)
//S.C : O(n)
class PlayersWithZeroOROneLosses {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map <Integer ,Integer> lostMap = new HashMap<>();

        for(int i = 0 ;i < matches.length;i++){
            int looser = matches[i][1];
            lostMap.put(looser, lostMap.getOrDefault(looser, 0) + 1);
        }

        List<Integer> neverLost = new ArrayList<>();
        List<Integer> lostOnce = new ArrayList<>();

        for(int i = 0; i < matches.length;i++){
            int loose = matches[i][1];
            int winner = matches[i][0];

            if(lostMap.get(loose) == 1){
                lostOnce.add(loose);
            }

            if(!lostMap.containsKey(winner)){
                neverLost.add(winner);
                lostMap.put(winner, 2);
            }

            
        }
        Collections.sort(neverLost);
        Collections.sort(lostOnce);

        return Arrays.asList(neverLost , lostOnce);
    }
}
