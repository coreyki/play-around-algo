class Solution {
    private String getEncode(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            }
            sb.append(map.get(s.charAt(i)) + " ");
        }
        return sb.toString();
    }
    
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        return getEncode(s).equals(getEncode(t));
    }
    //Time: O(n);
    //Space: O(n)
}
