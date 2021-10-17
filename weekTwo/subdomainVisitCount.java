class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        //key: domain 
        //value: count
        HashMap<String, Integer> map = new HashMap<>();
        for (String cpdomain: cpdomains) {
            String[] domainAndCountArr = cpdomain.split(" ");
            int curCount = Integer.valueOf(domainAndCountArr[0]);
            String[] domains = domainAndCountArr[1].split("\\.");
            String domain = "";
            for (int i = domains.length-1; i >= 0; i--) {
                if (i != domains.length-1) {
                    domain = "." + domain;
                }
                domain = domains[i] + domain;
                int count = map.getOrDefault(domain, 0) + curCount;
                map.put(domain, count);
            }
        }
        List<String> retList = new ArrayList<>();
        for (String key: map.keySet()) {
            String str = "" + map.get(key) + " " + key;
            retList.add(str);
        }
        return retList;
    }
    //Time: O(N)
    //Space: O(N)
}
