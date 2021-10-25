class Solution {
    HashMap<Integer, Integer> map;
    int[] nums;
    List<List<Integer>> retList;
    LinkedList<Integer> curList;
    public List<List<Integer>> permuteUnique(int[] nums) {
        map = new HashMap();
        this.nums = nums; 
        retList = new ArrayList<>();
        curList = new LinkedList<>();
        
        //map to record num and corresponding frequency
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        permute(0);
        return retList;
    }
    
    private void permute(int index) {
        if (index == nums.length) {
            retList.add(new ArrayList<Integer>(curList));
            return;
        }
        
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();            
            if (count == 0) continue;
            //add to curList
            curList.addLast(num);
            map.put(num, count-1);
            
            //go to next position
            permute(index+1);
            
            //recover state
            map.put(num, count);
            curList.removeLast();
        }
    }
    //Time: O(N^2)
    //Space: O(N)
}
