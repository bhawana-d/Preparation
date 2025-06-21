//https://leetcode.com/problems/smallest-number-in-infinite-set/
//Approach:1 -- normal brute force h basic sa

class SmallestInfiniteSet {
    boolean[] arr;
    int i;
    public SmallestInfiniteSet() {
        arr = new boolean[1001];
        Arrays.fill(arr,true);
        i = 1;
    }
    
    public int popSmallest() {
        int result = i;
        arr[i] = false;

        for(int j = i + 1; j < 1001;j++){
            if(arr[j] == true){
                i = j;
                break;
            }

           
        }

        return result;
    }
    
    public void addBack(int num) {
        arr[num] = true;
        if(num < i){
            i = num;
        }
    }
}

/////////////////////////////
///APPROACH - 2 =================== isme priorityQueue for min number and set ki addback krne ka ki nhi
class SmallestInfiniteSet {
    int currentSmallest;
    HashSet<Integer> set;
    PriorityQueue<Integer> pq;
    public SmallestInfiniteSet() {
        currentSmallest = 1;
        set = new HashSet<>();
        pq = new PriorityQueue<>();
    }
    
    public int popSmallest() {
        int result;
        if(! pq.isEmpty()){
            result = pq.poll();
            set.remove(result);
        }else{
            result = currentSmallest;
            currentSmallest++;
        }

        return result;
    }
    
    public void addBack(int num) {
        if(num >= currentSmallest || set.contains(num)){
            return;
        }
        set.add(num);
        pq.offer(num);
    }
}

/** Approach 3-------only set ka use kiya h --------**/
class SmallestInfiniteSet {
    int currentSmallest;
    TreeSet<Integer> s;
    public SmallestInfiniteSet() {
        currentSmallest = 1;
        s = new TreeSet<>();
    }
    
    public int popSmallest() {
        int result;
        if(!s.isEmpty()){
            result = s.pollFirst();
        }
        else{
            result = currentSmallest;
            currentSmallest++;
        }
        return result;
    }
    
    public void addBack(int num) {
        if(num >= currentSmallest ||  s.contains(num)){
            return;
        }
        s.add(num);
    }
}
