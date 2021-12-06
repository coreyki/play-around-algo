class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anaMap = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedStr = String.valueOf(arr);
            List<String> curList = anaMap.getOrDefault(sortedStr, new ArrayList<String>());
            curList.add(str);
            anaMap.put(sortedStr, curList);
        }
        List<List<String>> retList = new ArrayList<>(anaMap.values());
        return retList;
        //Time: O(nmlogm) where n is number of words and m is max length of the strings
        //Time: O(nmlogm)
    }
}
