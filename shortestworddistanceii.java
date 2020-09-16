//Java Solution

class WordDistance {

    Map<String, ArrayList<Integer>> map = new HashMap<>();
    
    public WordDistance(String[] words) {
        this.map = new HashMap<String, ArrayList<Integer>>();
        
        for (int i = 0; i < words.length; i++) {
            if (!this.map.containsKey(words[i])) {
                this.map.put(words[i], new ArrayList<Integer>());
                this.map.get(words[i]).add(i);
            } else {
                this.map.get(words[i]).add(i);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        ArrayList<Integer> arr1, arr2;
        
        arr1 = this.map.get(word1);
        arr2 = this.map.get(word2);
        int p1 = 0;
        int p2 = 0;
        int ans = Integer.MAX_VALUE;
        
        while (p1 < arr1.size() && p2 < arr2.size()) {
            int index1 = arr1.get(p1);
            int index2 = arr2.get(p2);
            
            ans = Math.min(ans, Math.abs(index2 - index1));
            if (index1 < index2) {
                p1++;
            } else {
                p2++;
            }
        }
        
        return ans;
    }
}